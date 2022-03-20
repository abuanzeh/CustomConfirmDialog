
# Explain 
An application does not have a dialog box to confirm an event.
This library is designed in a way that makes it easy for the developer to use a dialog box to confirm a specific event with a good and comfortable design, where you can modify what you want on the design to suit the shape of your application design.

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
	    //set Title
            .setTitle("Delete Item")
	    //setSubTitle
            .setSubTitle("Are Your sure you want\ndelete this item?")
	    //set Cancel Button Title
            .setButtonCancelText("CANCEL")
	    //set Confirm Button Title
            .setButtonConfirmText("CONFIRM")
	    //set if user can dismiss dilog true or false 
            .setEnableToDismiss(true)
	     //handle Clickes Buttons
            .setDialogButtonsCallBack(object : ConfirmDialogCallBack {
                override fun handleClickConfirmButton() {}

                override fun handleClickCancelButton() {}

                override fun handleWhenDialogDismiss() {}

            })
	    //set Main Color 
            .setMainColor(R.color.delete_color)
	    //set Custom Color
            .setIcon(R.drawable.ic_delete)
	    //set Corner Buttons Radius 
            .setCornerButtonsRadius(40)
	    //set Corner background Dialog 
            .setCornerRadius(20)
	    //setDialog Background
	    .setDialogColorBackground(R.color.your_color)
            .build()
            .showConfirmDialog()   
	    
```	    
