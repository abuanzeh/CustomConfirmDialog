package com.anzeh.customdialog.utils

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup


fun Dialog.addFullScreen() {
    window?.setLayout(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )
    window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
}
fun Dialog.setTransparentBackground(){
    window?.setBackgroundDrawableResource(android.R.color.transparent)
}

