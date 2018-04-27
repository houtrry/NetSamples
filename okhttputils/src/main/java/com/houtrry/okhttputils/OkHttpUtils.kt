package com.houtrry.okhttputils

import com.google.gson.reflect.TypeToken
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * @author: houtrry
 * @time: 2018/4/26
 * @desc: ${TODO}
 */
class OkHttpUtils {

    private object SingleInstance {
        val INSTANCE = OkHttpUtils()
    }

    val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .build()
    }

    companion object {
        private val okHttpClient = OkHttpClient()

        init {

        }

        fun getInstance(): OkHttpUtils {
            return SingleInstance.INSTANCE
        }
    }


    inline fun <reified T> get(url: String, callback: ApiResponseCallback<T>) {
        val request = Request.Builder()
                .url(url)
                .build()

        okHttpClient.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call?, e: IOException?) {
                callback.onFailure(request, e)
            }

            override fun onResponse(call: Call?, response: Response?) {
                if (response != null && response.isSuccessful) {
                    val bodyString = response.body()?.string()
                    if (bodyString == null) {
                        callback.onFailure(call?.request(), IOException("response is null"))
                        return
                    }
                    val type = object : TypeToken<T>() {}.type
                    System.out.println("type is $type")

                    callback.onSuccess(GsonUtils.getInstance().fromJson(bodyString, type))
                } else {
                    callback.onFailure(call?.request(), IOException("response is $response"))
                }
            }

        })
    }


    /**
     * 上面是按java的套路来写的，
     * 这个方法与上面的作用一样，只是不按照java的回调来写。省去了定义接口类。
     */
   inline fun <reified T> get(url: String, crossinline success: (data: T) -> Unit, crossinline failure: ((request: Request?, e: Exception?) -> Unit)) {
        val request = Request.Builder()
                .url(url)
                .build()

        okHttpClient.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call?, e: IOException?) {
                failure.invoke(request, e)
            }

            override fun onResponse(call: Call?, response: Response?) {
                if (response != null && response.isSuccessful) {
                    val bodyString = response.body()?.string()
                    if (bodyString == null) {
                        failure.invoke(call?.request(), IOException("response is null"))
                        return
                    }
                    val type = object : TypeToken<T>() {}.type
                    System.out.println("type is $type")

                    success.invoke(GsonUtils.getInstance().fromJson(bodyString, type))
                } else {
                    failure.invoke(call?.request(), IOException("response is $response"))
                }
            }

        })
    }

    inline fun <reified T> post(url: String, crossinline success:(data:T) -> Unit, crossinline failure: (request: Request?, e: Exception?) -> Unit) {
        val requestBody = FormBody.Builder().build()

        val request = Request.Builder()
                .url(url)
                .post(requestBody)
                .build()


    }
}