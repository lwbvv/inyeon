package com.example.inyeon

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class ActivityLogin: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login);

        loginGoogle.setOnClickListener{
            val nextIntent = Intent(this, ActivityMain::class.java)
            startActivity(nextIntent)
        }

        loginGeneralLogin.setOnClickListener {
            val toLogin = Intent(this@ActivityLogin, ActivityGeneralLogin::class.java)
            startActivity(toLogin)

        }

    }



}