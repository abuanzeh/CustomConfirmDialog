package com.anzeh.customdialog.utils

import android.content.Context
import android.util.TypedValue

fun Int.dpToPixels(context: Context): Float = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context.resources.displayMetrics
)