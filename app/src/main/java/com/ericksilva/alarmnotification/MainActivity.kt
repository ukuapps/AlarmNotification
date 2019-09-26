package com.ericksilva.alarmnotification

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        FirebaseInstanceId.getInstance().instanceId
                .addOnCompleteListener(OnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        Log.w("JOJO", "getInstanceId failed", task.exception)
                        return@OnCompleteListener
                    }
                    val token = task.result?.token
                    Log.e("JOJO", token)
                    Toast.makeText(baseContext, "lala = " + token, Toast.LENGTH_SHORT).show()
                })
    }
}
