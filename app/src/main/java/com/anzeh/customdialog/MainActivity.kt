package com.anzeh.customdialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anzeh.customdialog.utils.ConfirmDialogCallBack

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CustomConfirmDialog
            .Builder()
            .setContext(this)
            .setTitle("Delete Item")
            .setSubTitle("Are Your sure you want\ndelete this item?")
            .setButtonCancelText("CANCEL")
            .setButtonConfirmText("CONFIRM")
            .setEnableToDismiss(true)
            .setDialogButtonsCallBack(object : ConfirmDialogCallBack {
                override fun handleClickConfirmButton() {}

                override fun handleClickCancelButton() {}

                override fun handleWhenDialogDismiss() {}

            })
            .setMainColor(R.color.delete_color)
            .setIcon(R.drawable.ic_delete)
            .setCornerButtonsRadius(40)
            .setCornerRadius(20)
            .build()
            .showConfirmDialog()

    }
}