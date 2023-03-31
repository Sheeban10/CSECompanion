package com.example.cseCompanion

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.admin_login_protection.*

class AdminLoginProtection : AppCompatActivity(){

    private val CORRECT_PASSWORD = "myPassword123"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_login_protection)

        val passwordAdmin: EditText = findViewById(R.id.password_admn)

        btn_adminpw.setOnClickListener{
            val password = passwordAdmin.text.toString()

            if (password == CORRECT_PASSWORD) {
                val intent = Intent(this, LoginActivityAdmin::class.java)
                startActivity(intent)
            } else {
                // Password is incorrect, show an error message
                Toast.makeText(this, "Incorrect password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
