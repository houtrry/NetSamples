package com.houtrry.okhttputils

import com.google.gson.Gson
import java.lang.reflect.Type

/**
 * @author: houtrry
 * @time: 2018/4/26
 * @desc: ${TODO}
 */
class GsonUtils {
    private object SingleInstance {
        val INSTANCE = GsonUtils()
    }

    private val gson: Gson by lazy {
        Gson()
    }

    companion object {

        fun getInstance(): GsonUtils {
            return SingleInstance.INSTANCE
        }
    }

    fun <T> fromJson(json: String, cls: Class<T>): T {
        return gson.fromJson<T>(json, cls)
    }

    fun <T> fromJson(json: String, typeOfT: Type): T {
        System.out.println("type: ${typeOfT.javaClass.name}, json: $json")
        return gson.fromJson<T>(json, typeOfT)
    }

    fun toJson(src: Any): String {
        return gson.toJson(src)
    }
}