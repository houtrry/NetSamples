package com.houtrry.okhttpsamples.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.houtrry.basiclibrary.utils.LogUtils
import com.houtrry.okhttpsamples.R
import com.houtrry.okhttpsamples.bean.ArticleListBean
import com.houtrry.okhttpsamples.bean.ResponseResult
import com.houtrry.okhttputils.ApiResponseCallback
import com.houtrry.okhttputils.OkHttpUtils
import kotlinx.android.synthetic.main.activity_ok_http_utils.*
import okhttp3.Request

class OkHttpUtilsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ok_http_utils)
        btn_request_get.setOnClickListener { commonUsed() }
        btn_request_post_common.setOnClickListener { commonPost() }
        btn_request_post_upload_only_json.setOnClickListener { uploadPostOnlyJson() }
        btn_request_post_upload_only_file.setOnClickListener { uploadPostOnlyFile() }
        btn_request_post_upload_file_and_params.setOnClickListener { uploadPostFileAndParams() }
        btn_request_post_download.setOnClickListener { downloadPost() }
    }

    private fun commonUsed() {
        val url = "http://www.wanandroid.com/article/list/0/json"
        OkHttpUtils.getInstance().get(url, object : ApiResponseCallback<ResponseResult<ArticleListBean>> {
            override fun onSuccess(data: ResponseResult<ArticleListBean>) {
                LogUtils.d("onSuccess, data is $data")
            }

            override fun onFailure(request: Request?, e: Exception?) {
                LogUtils.d("onFailure, e is ${e?.message}")
            }

        })


        OkHttpUtils.getInstance().get<ResponseResult<ArticleListBean>>(url, {data -> run {
            LogUtils.d("success, data is $data")
        }}, {request, e -> run {
            LogUtils.d("failure, request: $request, e is ${e?.message}")
        }})
    }

    private fun commonPost() {

    }

    private fun uploadPostOnlyJson() {

    }

    private fun uploadPostOnlyFile() {

    }

    private fun uploadPostFileAndParams() {

    }


    private fun downloadPost() {

    }
}
