package com.houtrry.basiclibrary.utils

import android.util.Log

/**
 * @author: houtrry
 * @time: 2018/4/24
 * @desc: ${TODO}
 */
object LogUtils {

    var showLog = true

    fun d(message:String){
        if (showLog) {
            Log.d(Thread.currentThread().name, message)
        }
    }

    fun e(message:String){
        if (showLog) {
            Log.e(Thread.currentThread().name, message)
        }
    }

    fun showLog(showLog:Boolean) {
        this.showLog = showLog
    }
}