package com.houtrry.okhttpsamples

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.houtrry.basiclibrary.utils.startAty
import kotlinx.android.synthetic.main.activity_okhttp.*

class OkHttpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_okhttp)

        btn_common_used.setOnClickListener { startAty(CommonOkHttpUsedActivity::class.java) }
    }
}
