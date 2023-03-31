package com.example.cseCompanion

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import kotlin.concurrent.thread

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()

        thread(start = true) {
            try {
                Thread.sleep(100)

            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
               val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()


            }

        }
    }

}