package com.anzeh.customdialog.utils

import android.view.View


fun View.hide() {
    isEnabled = false
    visibility = View.INVISIBLE
}

fun View.show() {
    isEnabled = true
    visibility = View.VISIBLE
}

