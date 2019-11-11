package com.example.inyeon.dialog

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.LinearLayout
import java.io.File

interface DialogCameraInterface {
    fun cameraButtonClick(activity: Activity, getImageFile: File?)

    fun cancelButtonClick()

    fun removeButton(imageView: ImageView, array: Array<Bitmap>, imageArray : ArrayList<Bitmap>, position: Int, pictureContainer : ImageView)

    fun galleryButton(activity: Activity)
}