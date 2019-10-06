package com.example.inyeon

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.inyeon.sms.SmsReceiver
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.auth.api.phone.SmsRetrieverClient
import com.google.android.gms.tasks.Task
import kotlinx.android.synthetic.main.activity_signup_phonenumber.*


class ActivitySignUpPhoneNumber : AppCompatActivity() {
//    lateinit var smsReceiver: SmsReceiver
val phoneNumber = "phoneNumber"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_phonenumber)

//        smsReceiver = SmsReceiver()

        /*
        메인 회원가입으로 넘어가는 부분
         */
        signUpPhoneNumber_nextButton.setOnClickListener {
            if(signUpPhoneNumber_phoneNumber.text.toString() != ""){
                Log.e("number", signUpPhoneNumber_phoneNumber.text.toString() )
                var intent = Intent(this@ActivitySignUpPhoneNumber, ActivitySignUpMain::class.java)
                intent.putExtra(phoneNumber,signUpPhoneNumber_phoneNumber.text.toString())
                startActivity(intent)
            }
        }

    }











//    override fun onResume() {
//        super.onResume()
//
//        val client = SmsRetriever.getClient(this /* context */)
//        val task = client.startSmsRetriever()
//
//        task.addOnSuccessListener {
//            val intentFilter = IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION)
//            registerReceiver(smsReceiver, intentFilter)
//            Log.e("testest", "onSuccess")
//        }
//
//        task.addOnFailureListener { e -> Log.e("testest", "onFailure$e") }
//    }
}