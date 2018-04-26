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

    private val okHttpClient: OkHttpClient by lazy {
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


    fun <T> get(url: String, callback: ApiResponseCallback<T>) {
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
}