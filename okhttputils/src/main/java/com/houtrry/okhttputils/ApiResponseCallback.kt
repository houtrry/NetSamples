package com.houtrry.okhttputils

import okhttp3.Request

/**
 * @author: houtrry
 * @time: 2018/4/26
 * @desc: ${TODO}
 */
interface ApiResponseCallback<in T> {
    fun onSuccess(data:T)
    fun onFailure(request: Request?, e : Exception?)
}