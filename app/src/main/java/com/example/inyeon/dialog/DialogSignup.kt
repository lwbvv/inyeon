package com.example.inyeon.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.Button
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.TextView
import com.example.inyeon.R

class DialogSignupArea {
    lateinit var numberPicker: NumberPicker
    lateinit var context: Context
    lateinit var arrayString: Array<String>
    val dialog: Dialog
    lateinit var area: String
    lateinit var cancelButton : Button; lateinit var successButton : Button

    lateinit var profilePickerData : ProfilePickerData


    constructor(context: Context) {
        this.context = context
        dialog = Dialog(context)
        profilePickerData = ProfilePickerData()
    }



    fun initDialog(editText : EditText){
        dialog.setContentView(R.layout.dialog_signup_area)

        numberPicker = dialog.findViewById(R.id.dia_signUp_area_numberPicker)
        cancelButton = dialog.findViewById(R.id.dia_signUp_area_cancel)
        successButton = dialog.findViewById(R.id.dia_signUp_area_success)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        profilePickerData.init()

        cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        successButton.setOnClickListener {
            area = arrayString[numberPicker.value]
            editText.setText(area)
            dialog.dismiss()
        }
    }

    fun setStringPicker(dialogSelect : Int){
        var count = -1
            while (true){
                count++
            if (dialogSelect == count){
                numberPicker.minValue = 0
                numberPicker.maxValue = profilePickerData.profileTotalArray.get(count).size -1
                numberPicker.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
                numberPicker.displayedValues = profilePickerData.profileTotalArray.get(count)
            }
        }


    }


    fun setIntPicker(){
        numberPicker.minValue = 0
        numberPicker.maxValue = profilePickerData.heightArray.size - 1
        numberPicker.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
    }

    fun showDialog(){
        dialog.show()
    }

}