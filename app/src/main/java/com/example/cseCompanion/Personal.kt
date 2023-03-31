package com.example.cseCompanion

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_personal.*

class Personal : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal)

        supportActionBar?.title = "Student Info"

        val ref = FirebaseDatabase.getInstance().getReference("users")
        val user = FirebaseAuth.getInstance().uid
        if (user != null) {
            ref.child(user).get().addOnSuccessListener {
              val  username =  it.child("username").value
                val collegeRoll = it.child("collRollNo").value
                val email = it.child("email").value
                info_student_name.text = username.toString()
                info_rollno.text = collegeRoll.toString()
                info_email.text = email.toString()
            }.addOnFailureListener {
                Toast.makeText(this,it.message, Toast.LENGTH_LONG).show()
            }
        }



    }
}