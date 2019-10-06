//package com.example.inyeon
//
//import android.content.IntentFilter
//import android.os.Bundle
//import android.support.v7.app.AppCompatActivity
//import android.util.Log
//import com.example.inyeon.sms.SmsReceiver
//import com.google.android.gms.auth.api.phone.SmsRetriever
//import com.google.android.gms.auth.api.phone.SmsRetrieverClient
//import com.google.android.gms.tasks.OnFailureListener
//import com.google.android.gms.tasks.OnSuccessListener
//import com.google.android.gms.tasks.Task
//
//class MainActivity : AppCompatActivity() {
//    lateinit var smsReceiver: SmsReceiver
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        smsReceiver = SmsReceiver()
//    }
//
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
//
//}
