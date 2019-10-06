package com.example.inyeon

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.inyeon.server.RetrofitConfig
import kotlinx.android.synthetic.main.activity_signup_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ActivitySignUpMain : AppCompatActivity() , View.OnClickListener {

    var server: RetrofitConfig? = null
    val phoneNumberKey = "phoneNumber"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_main)


        var intent = getIntent()
        var phoneNumber:String ?= intent?.extras?.getString(phoneNumberKey)
        signUpMain_phoneNumber?.setText(phoneNumber)
        signUpMain_phoneNumber.isEnabled = false
//        var serverUrl = "http://ec2-15-164-221-8.ap-northeast-2.compute.amazonaws.com:8000/"
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.signUpMain_backButton -> finish()

            R.id.signUpMain_nextButton ->{

            }

            R.id.signUpMain_idCheckButton ->{

            }
        }
    }

}