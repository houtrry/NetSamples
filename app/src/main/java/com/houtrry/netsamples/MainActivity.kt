package com.houtrry.netsamples

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.houtrry.okhttpsamples.ui.OkHttpActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.houtrry.basiclibrary.utils.startAty


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_ok_http.setOnClickListener { startAty(OkHttpActivity::class.java) }
    }
}
