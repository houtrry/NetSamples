package com.houtrry.okhttpsamples.ui

import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.houtrry.basiclibrary.utils.LogUtils
import com.houtrry.okhttpsamples.R
import com.houtrry.okhttpsamples.bean.ArticleListBean
import com.houtrry.okhttpsamples.bean.LoginBean
import com.houtrry.okhttpsamples.bean.ResponseResult
import kotlinx.android.synthetic.main.activity_common_ok_http_used.*
import okhttp3.*
import java.io.File
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
                if (e != null || e!!.message != null) LogUtils.e(e!!.message!!) else LogUtils.e("get请求失败")
            }

            override fun onResponse(call: Call?, response: Response?) {
                if (response != null && response.isSuccessful) {
                    val gson = Gson()
                    val type = object : TypeToken<ResponseResult<ArticleListBean>>() {}.type
                    val responseString = response?.body()?.string()
                    val responseResult = gson.fromJson<ResponseResult<ArticleListBean>>(responseString, type)
                    LogUtils.e("===>responseResult: "+responseResult)
                    LogUtils.e("get请求成功")
                } else {
                    LogUtils.e("get请求失败, 没有返回数据")
                }
            }
        })
    }

    private fun commonPost() {
        val url = "http://www.wanandroid.com/user/login"
        val okHttpClient = OkHttpClient()
        val formBody = FormBody.Builder()
        formBody.add("username", "houtrry")
                .add("password","7dahuang7")

        val request = Request.Builder()
                .url(url)
                .post(formBody.build())
                .build()

        okHttpClient.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call?, e: IOException?) {
                LogUtils.e("===>>>responseResult, 请求失败 ")
            }

            override fun onResponse(call: Call?, response: Response?) {
                if (response != null && response.isSuccessful) {
                    val gson = Gson()
                    val type = object :TypeToken<ResponseResult<LoginBean>>(){}.type
                    val responseResult = gson.fromJson<ResponseResult<LoginBean>>(response?.body()?.string(), type)
                    LogUtils.e("===>>>responseResult: "+responseResult)
                    LogUtils.e("===>>>responseResult, 请求成功 ")
                } else {
                    LogUtils.e("===>>>responseResult, 请求失败, 没数据 ")
                }
            }
        })
    }

    private fun uploadPost() {
        val url = "http://www.baidu.com"
        val okHttpClient = OkHttpClient()
        val mediaType = MediaType.parse("File/*")
        val filePath = Environment.getExternalStorageDirectory().getPath() + "/" + "app-release.apk"
        val file = File(filePath)
        LogUtils.e("===>>>filePath: "+filePath)
        LogUtils.e("===>>>size: "+file.length())
        val requestBody = RequestBody.create(mediaType, file)
        val request = Request.Builder()
                .url(url)
                .post(requestBody)
                .build()

        okHttpClient.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call?, e: IOException?) {
                LogUtils.e("===>>>uploadPost, onFailure, e: "+e)
            }

            override fun onResponse(call: Call?, response: Response?) {
                if (response != null && response.isSuccessful) {
                    val body = response.body()?.string()
                    LogUtils.e("===>>>uploadPost, onResponse, body: " + body)
                }else{
                    LogUtils.e("===>>>uploadPost, onResponse, 失败， 没数据  ")
                }
            }

        })
    }

    private fun downloadPost() {
        //https://blog.csdn.net/fightingXia/article/details/70947701

        val okHttpClient = OkHttpClient()


    }


}
