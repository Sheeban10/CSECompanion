package com.example.csecompanionadminapp

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.cseCompanion.R
import com.example.csecompanionadminapp.model.StudentMstMarks
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_mst_marks_upload_admin.*

class AssignmentMarksAdmin: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment_marks_admin)

        val username = intent.getStringExtra("username")
        val rollNo = intent.getStringExtra("rollNo")

        supportActionBar?.title = username.toString()

        student_name.text = username.toString()
        roll_no.text = rollNo.toString()

        setDataToFields()

        submit_button.setOnClickListener {

            saveDataToFirebase()
        }

    }

    private fun setDataToFields() {

        val uid = intent.getStringExtra("uid")

        val ref = FirebaseDatabase.getInstance().getReference("/Assignments/Assignment 1/$uid")

        ref.get().addOnSuccessListener {
            if (it.exists()){
                nsc_marks.setText(it.child("nsc").value.toString())
                dmdw_marks.setText(it.child("dmdw").value.toString())
                bd_marks.setText(it.child("bd").value.toString())
                ddb_marks.setText(it.child("ddb").value.toString())
                adhoc_marks.setText(it.child("adhoc").value.toString())
            }

        }.addOnFailureListener {
            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
        }
    }


    private fun saveDataToFirebase() {

        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Saving data")
        progressDialog.setMessage("Please wait..")
        progressDialog.show()

        val username = intent.getStringExtra("username")
        val uid = intent.getStringExtra("uid")
        val rollNo = intent.getStringExtra("rollNo")

        val ref = FirebaseDatabase.getInstance().getReference("/Assignments/Assignment 1/$uid")

        val student = StudentMstMarks(
            uid,
            username.toString(),
            rollNo.toString(),
            nsc_marks.text.toString(),
            dmdw_marks.text.toString(),
            bd_marks.text.toString(),
            ddb_marks.text.toString(),
            adhoc_marks.text.toString(),
            System.currentTimeMillis() / 1000
        )

        ref.setValue(student)
            .addOnSuccessListener {
                progressDialog.hide()
                Toast.makeText(this, "Record Saved Successfully", Toast.LENGTH_LONG).show()
                Log.d("save", "data saved")
            }.addOnFailureListener {
                Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
            }


    }
}