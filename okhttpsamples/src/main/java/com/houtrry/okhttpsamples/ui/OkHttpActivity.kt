package com.houtrry.okhttpsamples.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.houtrry.basiclibrary.utils.startAty
import com.houtrry.okhttpsamples.R
import kotlinx.android.synthetic.main.activity_okhttp.*

class OkHttpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_okhttp)

        btn_common_used.setOnClickListener { startAty(CommonOkHttpUsedActivity::class.java) }
        btn_ok_http_utils_used.setOnClickListener { startAty(OkHttpUtilsActivity::class.java) }
    }
}
