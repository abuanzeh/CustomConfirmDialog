
# Explain 
This library displays a dialog to confirm a specific action, such as deleting an item or adding an item.

# Screenshots

![Alt text](https://firebasestorage.googleapis.com/v0/b/recalcerview.appspot.com/o/Screenshot_20220320-162304_Custom_Confirm_Dialog%5B1%5D.jpg?alt=media&token=cc5a9556-bbe2-4e67-bde2-eb53eb77112a)

![Alt text](https://firebasestorage.googleapis.com/v0/b/recalcerview.appspot.com/o/Screenshot_20220320-162212_Custom_Confirm_Dialog%5B1%5D.jpg?alt=media&token=9992a6c4-b523-41e9-84c9-380d7cf00289)

# Dependencies 
Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Add the dependency :
```
implementation 'com.github.abuanzeh:CustomConfirmDialog:1.0.2'


```

# Example 
```
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
	    
```	    
