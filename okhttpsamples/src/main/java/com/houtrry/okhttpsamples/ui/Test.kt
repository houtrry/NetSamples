package com.houtrry.okhttpsamples.ui


import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * @author: houtrry
 * @time: 2018/4/26
 * @desc: ${TODO}
 */
class Test {

    private object SingleInstance {
        val INSTANCE = Test()
    }

    private constructor() {

    }

    private constructor(okHttpClient: OkHttpClient) {
        sOkHttpClient = okHttpClient
    }

    companion object {
        private  var sOkHttpClient: OkHttpClient? = null

        init {
            sOkHttpClient = OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build()
        }

        fun getInstance():Test{
            return SingleInstance.INSTANCE
        }
    }


}
