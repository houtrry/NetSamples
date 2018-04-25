package com.houtrry.basiclibrary.utils

import android.os.Environment

/**
 * @author: houtrry
 * @time: 2018/4/25
 * @desc: ${TODO}
 */
object FileUtils {

    /**
     * 获取内置sd卡路径
     */
    fun getInnerSdCardPath(): String {
        return Environment.getExternalStorageDirectory().getPath()
    }

}