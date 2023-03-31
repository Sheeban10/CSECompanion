package com.example.cseCompanion

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        auth = FirebaseAuth.getInstance()


        fpSubmit_button.setOnClickListener {
            signUpUser()
        }
    }


    private fun signUpUser(){
        if (fp_email.text.toString().isEmpty()) {
            fp_email.error = "Please enter email"
            fp_email.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(fp_email.text.toString()).matches()) {
            fp_email.error = "Please enter valid email"
            fp_email.requestFocus()
            return
        }


        auth.sendPasswordResetEmail(fp_email.text.toString())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this,"Email sent successfully",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,LoginActivity::class.java))
                        finish()
                    }
                }.addOnFailureListener {
                Toast.makeText(this,it.message,Toast.LENGTH_LONG).show()
            }

    }
}