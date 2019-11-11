package com.example.inyeon.dialog

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.FileProvider
import androidx.core.content.res.ResourcesCompat
import com.example.inyeon.R
import com.example.inyeon.base.RequestCode
import kotlinx.android.synthetic.main.dialog_camera.*
import java.io.File
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.util.Log
import android.widget.LinearLayout
import androidx.core.content.ContextCompat


class DialogCamera : DialogCameraInterface {
    lateinit var context: Context
    lateinit var activity: Activity
    val dialog: Dialog
    lateinit var cancelButton: Button;
    lateinit var cameraButton: Button;
    lateinit var removeButton: Button
    lateinit var galleryButton : Button

    constructor(context: Context, activity: Activity) {
        this.context = context
        this.activity = activity
        dialog = Dialog(context)
        dialog.setContentView(R.layout.dialog_camera)
    }

    fun initDialog(getImageFile: File?) {

        /**
         * 버튼
         */
        cancelButton = dialog.findViewById(R.id.dialog_camera_cancel)
        cameraButton = dialog.findViewById(R.id.dialog_camera_cameraButton)
        removeButton = dialog.findViewById(R.id.dialog_camera_removeButton)
        galleryButton = dialog.findViewById(R.id.dialog_camera_galleryButton)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        cameraButtonClick(activity, getImageFile)
        galleryButton(activity)
        cancelButtonClick()
    }

    fun showDialog(){
        dialog.show()
    }

    override fun cameraButtonClick(activity: Activity, getImageFile: File?) {
        cameraButton.setOnClickListener {
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            var file = getImageFile
            Log.e("실행여부", "카메라" + getImageFile)
            var uri: Uri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) FileProvider.getUriForFile(context, "com.example.inyeon", file!!) else Uri.fromFile(file)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri) // 4
            startActivityForResult(activity, intent, RequestCode.REQUEST_IMAGE_CAPTURE, Bundle())
            dialog.dismiss()
        }
    }
    override fun galleryButton(activity: Activity) {
        galleryButton.setOnClickListener {
            var intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            Log.e("실행여부", "갤러리")
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
                var mimeType = arrayOf("image/jpeg", "image/png")
                intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeType)
            }
            startActivityForResult(activity,Intent.createChooser(intent,"Select Picture"), RequestCode.REQUEST_GALLREY, Bundle())
            dialog.dismiss()
        }
    }

    override fun cancelButtonClick() {
        cancelButton.setOnClickListener {
            dialog.dismiss()
        }
    }


    override fun removeButton(imageView: ImageView, array: Array<Bitmap>, imageArray : ArrayList<Bitmap>, position: Int, pictureContainer :ImageView) {
        removeButton.setOnClickListener {
//            imageView.setImageBitmap(array[position])
            imageArray.removeAt(position)
//            activity.setContentView(pictureContainer)

                imageView.setImageBitmap(imageArray[position])

            dialog.dismiss()
        }
    }


    fun viewVisibility(imageView: ImageView, drawableResources: Array<Bitmap>, position: Int, arraySize : Int) {
        var bitmapDrawble = imageView.drawable as BitmapDrawable
        var imageBitmap: Bitmap = bitmapDrawble.bitmap
        if (arraySize < 1) { //사진이 아무것도 없을 때에는 갤러리와 삭제 버튼을 아예 안 보이게 해 준다
            dialog.dialog_camera_galleryButton.visibility = View.GONE
            dialog.dialog_camera_galleryLine.visibility = View.GONE
            dialog.dialog_camera_removeButton.visibility = View.GONE
            dialog.dialog_camera_removeLine.visibility = View.GONE
        }else{          //갤러리에 사진이 1장이라도 있는 경우
            dialog.dialog_camera_galleryButton.visibility = View.VISIBLE
            dialog.dialog_camera_galleryLine.visibility = View.VISIBLE
            if (imageBitmap != drawableResources[position-1]) { //해당 포지션에 사진이 있으면
                dialog.dialog_camera_removeButton.visibility = View.VISIBLE
                dialog.dialog_camera_removeLine.visibility = View.VISIBLE
            } else {      //해당 포지션에 사진이 없으면
                dialog.dialog_camera_removeButton.visibility = View.GONE
                dialog.dialog_camera_removeLine.visibility = View.GONE
            }
        }


    }
}