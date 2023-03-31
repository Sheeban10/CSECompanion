package com.example.cseCompanion

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()
        FirebaseMessaging.getInstance().subscribeToTopic("Notifications")

        forgotPassword.setOnClickListener {
            val intent = Intent(this,ForgotPasswordActivity::class.java)
            startActivity(intent)



        }

        btn_admin_login.setOnClickListener{
            val intent = Intent(this, AdminLoginProtection::class.java)
            startActivity(intent)}


        login_button.setOnClickListener {

            progressBar.visibility = View.VISIBLE

            if (login_email.text?.trim().toString().isNotEmpty() || login_password.text?.trim().toString().isNotEmpty()){

                signInUser(
                    login_email.text?.trim().toString(),
                    login_password.text?.trim().toString()
                )

            }else{
                progressBar.visibility = View.GONE
                Toast.makeText(this,"Input required",Toast.LENGTH_LONG).show()
            }

        }
    }
    override fun onStart() {
        super.onStart()
        val user = auth.currentUser

        if (user != null){
            startActivity(Intent(this,NavActivity::class.java))
            finish()
        }
    }

    fun registerFun(view: View) {
        val intent = Intent(this,SignUpActivity::class.java)
        startActivity(intent)
    }

    private fun signInUser(email:String, password:String){

        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener (this){ task ->
                if (task.isSuccessful){
                    progressBar.visibility = View.GONE
                    startActivity(Intent(this,NavActivity::class.java))
                    finish()

                }else{
                    progressBar.visibility = View.GONE
                    Toast.makeText(this,"Error ! " + "Invalid Password or Username", Toast.LENGTH_SHORT).show()
                }


            }

    }
}


