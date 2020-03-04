package com.example.bubblepicker.Until

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.widget.Toast
import com.example.bubblepicker.MainActivity

class SmsRecieving : BroadcastReceiver() {
    val SMS_BUNDLE = "pdus"
    override fun onReceive(context: Context?, intent: Intent) {
        val intentExtras = intent.extras
        if (intentExtras != null) {
            val sms =
                intentExtras[SMS_BUNDLE] as Array<Any>?
            var smsMessageStr = ""
            for (i in sms!!.indices) {
                val smsMessage =
                    SmsMessage.createFromPdu(sms[i] as ByteArray)
                val smsBody = smsMessage.messageBody.toString()
                val address = smsMessage.originatingAddress
                smsMessageStr += "SMS From: $address\n"
                smsMessageStr += smsBody + "\n"
            }
            Toast.makeText(context, smsMessageStr, Toast.LENGTH_SHORT).show()
            val inst: MainActivity = MainActivity()
            inst.addlist(smsMessageStr)
            print("444444444$smsMessageStr")
            //this will update the UI with message
        }
    }
}