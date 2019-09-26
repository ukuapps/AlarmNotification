package com.ericksilva.alarmnotification

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.e("JOJO", "From: ${remoteMessage.from}")

        val intent = Intent(applicationContext, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)

    }

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
        Log.e("JOJO", "New token: ${p0}")
    }

}