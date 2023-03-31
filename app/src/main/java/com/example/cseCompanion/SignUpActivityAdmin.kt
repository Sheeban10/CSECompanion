package com.example.csecompanionadminapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cseCompanion.LoginActivityAdmin
import com.example.cseCompanion.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up_admin.*

class SignUpActivityAdmin : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_admin)

        auth = FirebaseAuth.getInstance()

        //window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)


        register_button.setOnClickListener {

            signUpUser()
        }


    }

    private fun signUpUser(){
        if (signUp_name.text.toString().isEmpty()){
            signUp_name.error = "Please enter full name"
            signUp_name.requestFocus()
            return
        }


        if (signUp_email.text.toString().isEmpty()){
            signUp_email.error = "Please enter email"
            signUp_email.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(signUp_email.text.toString()).matches()){
            signUp_email.error = "Please enter valid email"
            signUp_email.requestFocus()
            return
        }


        if(signUp_password.text.toString().isEmpty()){
            signUp_password.error = "Please enter password"
            signUp_password.requestFocus()
            return
        }

        progressBar.visibility = View.VISIBLE

        auth.createUserWithEmailAndPassword(signUp_email.text.toString(),signUp_password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    saveUserToFirebaseDatabase()
                    // Sign in success, update UI with the signed-in user's information
                     progressBar.visibility = View.GONE
                    startActivity(Intent(this,MainActivityAdmin::class.java))
                    Log.d("signUp Activity","user uid is:${task.result?.user?.uid}")
                    finish()
                } else {
                    // If sign in fails, display a message to the user.
                     progressBar.visibility = View.GONE
                    Toast.makeText(baseContext, "Authentication failed." + task.exception,
                        Toast.LENGTH_SHORT).show()
                }
            }.addOnFailureListener {
                Toast.makeText(this,"${it.message}",Toast.LENGTH_LONG).show()
                }

    }

    private fun saveUserToFirebaseDatabase() {
        val uid = FirebaseAuth.getInstance().uid ?: ""
        val ref = FirebaseDatabase.getInstance().getReference("/Mentors/$uid")

        val user = UserData(uid,signUp_name.text.toString(),signUp_email.text.toString())

            ref.setValue(user)
                    .addOnSuccessListener {
                        Log.d("SignUp","User saved")
        } .addOnFailureListener {
            Toast.makeText(this,"${it.message}",Toast.LENGTH_LONG).show()
                    }
    }

    fun signInFun(view: View) {
        val intent = Intent(this, LoginActivityAdmin::class.java)
        startActivity(intent)
    }


}
class UserData(val uid:String, val username: String, val email: String)