package com.example.inyeon.sms

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.api.Status
import com.google.android.gms.common.api.CommonStatusCodes

class SmsReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {
        if(SmsRetriever.SMS_RETRIEVED_ACTION==intent?.action){//SMS
            var extras : Bundle =intent.extras
            var status = extras!!.get(SmsRetriever.EXTRA_STATUS) as Status

            when (status.statusCode){
                CommonStatusCodes.SUCCESS ->{
                    val message = extras.get(SmsRetriever.EXTRA_SMS_MESSAGE) as String }

                CommonStatusCodes.TIMEOUT ->{

                    //기본 Timeout 시간 5분

                }
            }
        }
    }
}