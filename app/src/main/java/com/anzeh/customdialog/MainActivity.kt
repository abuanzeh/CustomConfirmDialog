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
            .setTitle("Title")
            .setSubTitle("Sub Title")
            .setEnableToDismiss(true)
            .setDialogButtonsCallBack(object : ConfirmDialogCallBack {
                override fun handleClickConfirmButton() {
                }

                override fun handleClickCancelButton() {
                }

                override fun handleWhenDialogDismiss() {

                }

            })
            .setMainColor(R.color.black)
            .setIcon(R.drawable.ic_check)
            .setCornerButtonsRadius(40)
            .setCornerRadius(20)
            .setSubTitle("Sub Title")
            .setButtonCancelText("CANCEL")
            .setButtonConfirmText("CONFIRM")

    }
}