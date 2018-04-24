package com.houtrry.basiclibrary.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * @author: houtrry
 * @time: 2018/4/24
 * @desc: ${TODO}
 */

fun Context.startAty(cls:Class<out Activity>) {
    val intent = Intent(this, cls)
    this.startActivity(intent)
}

fun Context.showToast(message:String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.showLongToast(message:String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}