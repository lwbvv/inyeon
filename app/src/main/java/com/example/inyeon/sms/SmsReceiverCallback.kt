package com.example.inyeon.sms

interface SmsReceiverCallback {

    fun onReceive(senderNo: String, messageBody: String)
}