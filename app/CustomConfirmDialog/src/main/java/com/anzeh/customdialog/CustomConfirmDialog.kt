package com.anzeh.customdialog

import android.app.Dialog
import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.anzeh.customdialog.databinding.CustomConfirmDialogBinding
import com.anzeh.customdialog.utils.*


open class CustomConfirmDialog private constructor(
    var builder: Builder,
) {

    private var dialogConfirm: Dialog? = builder.getContext()?.let { Dialog(it) }
    private var context: Context

    private val binding: CustomConfirmDialogBinding =
        DataBindingUtil.inflate(
            LayoutInflater.from(
                builder.getContext()
            ), R.layout.custom_confirm_dialog, null, false
        )

    init {
        context = builder.getContext()!!
    }

    fun dismissConfirmDialog() {
        dialogConfirm?.dismiss()
    }

    fun showConfirmDialog() {

        setUpDialog()
        setUpDialogTitle()
        setUpDialogSubTitle()
        setUpListener()
        setUpIcon()
        setUpDialogButtons()
        dialogConfirm?.show()

    }

    private fun setUpIcon() {
        builder.getIcon()?.let { binding.logo.setImageResource(it) }
    }

    private fun setUpDialogButtons() {
        builder.getButtonCancelTextColor()?.let {
            binding.btnCancel.setTextColor(
                ContextCompat.getColor(
                    context,
                    it
                )
            )
        }

        builder.getButtonConfirmTextColor()?.let {
            binding.btnConfirm.setTextColor(
                ContextCompat.getColor(
                    context,
                    it
                )
            )
        }

        builder.getCornerRadius()?.let {
            binding.cvContainer.radius = context.let { it1 -> it.dpToPixels(it1) }
        }

        builder.getCornerButtonsRadius()?.let {
            binding.btnCancel.cornerRadius = it
            binding.btnConfirm.cornerRadius = it
        }
        binding.btnConfirm.text = builder.getButtonConfirmText()
        binding.btnCancel.text = builder.getButtonCancelText()

        val colorInt: Int? = builder.getMainColor()?.let { ContextCompat.getColor(context, it) }
        val csl = colorInt?.let { ColorStateList.valueOf(it) }
        binding.btnCancel.strokeColor = csl

        builder.getMainColor()?.let {
            binding.btnConfirm.background.setTint(
                ContextCompat.getColor(
                    context,
                    it
                )
            )
        }

    }

    private fun setUpDialogTitle() {
        binding.tvTitle.text = builder.getTitle()
        builder.getTitleColor()?.let {
            binding.tvTitle.setTextColor(ContextCompat.getColor(context, it))
        }
    }


    private fun setUpDialogSubTitle() {
        binding.tvSubTitle.text = builder.getSubTitle()
        builder.getSubTitleColor()?.let {
            binding.tvSubTitle.setTextColor(
                ContextCompat.getColor(
                    context,
                    it
                )
            )

        }
    }


    private fun setUpDialog() {

        builder.getEnableToDismiss()?.let { enable ->
            dialogConfirm?.setCancelable(enable)
            if (enable) {
                binding.imgClose.show()
            } else {
                binding.imgClose.hide()
            }
        }

        builder.getContext()?.let { context ->
            builder.getDialogColorBackground()?.let { color ->
                binding.clContainer.setBackgroundColor(ContextCompat.getColor(context, color))
            }
        }

        dialogConfirm?.setContentView(binding.root)
        dialogConfirm?.addFullScreen()
        dialogConfirm?.setTransparentBackground()
    }

    private fun setUpListener() {
        binding.btnCancel.setOnClickListener {
            builder.getDialogButtonsCallBack()?.handleClickCancelButton()
            dialogConfirm?.dismiss()
        }

        binding.btnConfirm.setOnClickListener {
            builder.getDialogButtonsCallBack()?.handleClickConfirmButton()
            dialogConfirm?.dismiss()
        }

        dialogConfirm?.setOnCancelListener {
            builder.getDialogButtonsCallBack()?.handleWhenDialogDismiss()
        }
    }


    class Builder {
        private var context: Context? = null
        private var title: String? = null
        private var titleColor: Int? = null
        private var subTitle: String? = null
        private var subTitleColor: Int? = null
        private var confirmDialogCallBack: ConfirmDialogCallBack? = null
        private var enableToDismiss: Boolean? = null

        private var cornerRadius: Int? = null
        private var dialogColorBackground: Int? = null
        private var cornerButtonsRadius: Int? = null

        private var buttonConfirmText: String? = null
        private var buttonConfirmTextColor: Int? = null

        private var mainColor: Int? = null

        private var buttonCancelText: String? = null
        private var buttonCancelTextColor: Int? = null

        private var icon: Int? = null

        fun getContext(): Context? {
            return context
        }

        fun setContext(context: Context): Builder {
            this.context = context
            return this
        }


        fun getEnableToDismiss(): Boolean? {
            return enableToDismiss
        }


        fun get(): Boolean? {
            return enableToDismiss
        }

        fun getDialogButtonsCallBack(): ConfirmDialogCallBack? {
            return confirmDialogCallBack
        }


        fun setDialogButtonsCallBack(confirmDialogCallBack: ConfirmDialogCallBack?): Builder {
            this.confirmDialogCallBack = confirmDialogCallBack
            return this
        }

        fun setEnableToDismiss(enableToDismiss: Boolean): Builder {
            this.enableToDismiss = enableToDismiss
            return this
        }


        fun setCornerRadius(cornerRadius: Int): Builder {
            this.cornerRadius = cornerRadius
            return this
        }

        fun getCornerRadius(): Int? {
            return cornerRadius
        }

        fun setCornerButtonsRadius(cornerButtonsRadius: Int): Builder {
            this.cornerButtonsRadius = cornerButtonsRadius
            return this
        }

        fun getCornerButtonsRadius(): Int? {
            return cornerButtonsRadius
        }

        fun getMainColor(): Int? {
            return mainColor
        }

        fun setMainColor(mainColor: Int): Builder {
            this.mainColor = mainColor
            return this
        }

        fun getButtonConfirmTextColor(): Int? {
            return buttonConfirmTextColor
        }

        fun setButtonConfirmTextColor(buttonConfirmColor: Int): Builder {
            this.buttonConfirmTextColor = buttonConfirmColor
            return this
        }

        fun getButtonCancelTextColor(): Int? {
            return buttonCancelTextColor
        }

        fun setButtonCancelTextColor(buttonCancelColor: Int): Builder {
            this.buttonCancelTextColor = buttonCancelColor
            return this
        }


        fun getTitle(): String? {
            return title
        }

        fun setTitle(title: String): Builder {
            this.title = title
            return this
        }

        fun getSubTitle(): String? {
            return subTitle
        }

        fun setSubTitle(subTitle: String): Builder {
            this.subTitle = subTitle
            return this
        }

        fun getButtonConfirmText(): String? {
            return buttonConfirmText
        }

        fun setButtonConfirmText(buttonConfirmText: String): Builder {
            this.buttonConfirmText = buttonConfirmText
            return this
        }


        fun getButtonCancelText(): String? {
            return buttonCancelText
        }

        fun setButtonCancelText(buttonCancelText: String): Builder {
            this.buttonCancelText = buttonCancelText
            return this
        }

        fun setIcon(icon: Int): Builder {
            this.icon = icon
            return this
        }

        fun getTitleColor(): Int? {
            return titleColor
        }

        fun setDialogColorBackground(dialogColorBackground: Int): Builder {
            this.dialogColorBackground = dialogColorBackground
            return this
        }

        fun getDialogColorBackground(): Int? {
            return dialogColorBackground
        }

        fun setSubTitleColor(subTitleColor: Int): Builder {
            this.subTitleColor = subTitleColor
            return this
        }

        fun getSubTitleColor(): Int? {
            return subTitleColor
        }

        fun setTitleColor(titleColor: Int): Builder {
            this.titleColor = titleColor
            return this
        }

        fun getIcon(): Int? {
            return icon
        }

        fun build(): CustomConfirmDialog {
            return CustomConfirmDialog(this)
        }
    }

}
