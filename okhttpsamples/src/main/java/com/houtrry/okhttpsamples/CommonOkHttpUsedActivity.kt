package com.houtrry.okhttpsamples

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.houtrry.basiclibrary.utils.LogUtils
import com.houtrry.basiclibrary.utils.showToast
import kotlinx.android.synthetic.main.activity_common_ok_http_used.*
import okhttp3.*
import java.io.IOException


class CommonOkHttpUsedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common_ok_http_used)

        btn_request_get.setOnClickListener { commonUsed() }
        btn_request_post_common.setOnClickListener { commonPost() }
        btn_request_post_upload.setOnClickListener { uploadPost() }
        btn_request_post_download.setOnClickListener { downloadPost() }
    }

    private fun commonUsed() {
        val url = "http://www.wanandroid.com/article/list/0/json"
        val okHttpClient = OkHttpClient()
        val request = Request.Builder()
                .url(url)
                .build()
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                if (e != null || e!!.message != null) {
                    showToast(e!!.message!!)
                }
            }

            override fun onResponse(call: Call?, response: Response?) {
                val gson = Gson()
                val type = object:TypeToken<ResponseResult<ArticleListBean>>(){}.type
                val responseString = response?.body().toString()
                LogUtils.d("===>>>"+responseString)
                val responseResult = gson.fromJson<ResponseResult<ArticleListBean>>(responseString, type)
                LogUtils.d("===>>>"+responseResult.toString())
            }
        })
    }

    private fun commonPost() {

    }

    private fun uploadPost() {

    }

    private fun downloadPost() {

    }
}
