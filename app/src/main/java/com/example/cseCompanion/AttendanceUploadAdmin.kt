package com.example.csecompanionadminapp

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cseCompanion.R
import com.example.csecompanionadminapp.model.StudentAttendance
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_attendance_uploadad_admin.*
import kotlinx.android.synthetic.main.activity_mst_marks_upload_admin.*
import kotlinx.android.synthetic.main.activity_mst_marks_upload_admin.roll_no
import kotlinx.android.synthetic.main.activity_mst_marks_upload_admin.student_name
import kotlinx.android.synthetic.main.activity_mst_marks_upload_admin.submit_button

class AttendanceUploadAdmin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance_uploadad_admin)

        val username = intent.getStringExtra("username")
        val rollNo = intent.getStringExtra("rollNo")

        supportActionBar?.title = username.toString()

        student_name.text = username.toString()
        roll_no.text = rollNo.toString()

        setDataToFields()

        submit_button.setOnClickListener {

             saveDataToFirebase()
            val time = System.currentTimeMillis()
        }

    }

    private fun setDataToFields() {

        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading data")
        progressDialog.setMessage("Application is loading, please wait")
        progressDialog.show()

        val uid = intent.getStringExtra("uid")

        val ref = FirebaseDatabase.getInstance().getReference("/Attendance/$uid")

        ref.get().addOnSuccessListener {

            progressDialog.hide()

            if (it.exists()){
                ddb_attendance.setText(it.child("attendDdb").value.toString())
                ddb_lab_attendance.setText(it.child("attendDdbLab").value.toString())
                adhoc_attendance.setText(it.child("attendAdhoc").value.toString())
                adhoc_lab_attendance.setText(it.child("attendAdhocLab").value.toString())
                bd_attendance.setText(it.child("attendBd").value.toString())
                nsc_attendance.setText(it.child("attendNsc").value.toString())
                dmdw_attendance.setText(it.child("attendDwdm").value.toString())
                project_lab_attendance.setText(it.child("attendProjLab").value.toString())
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

        val ref = FirebaseDatabase.getInstance().getReference("/Attendance/$uid")

        val student = StudentAttendance(ddb_attendance.text.toString(),
        ddb_lab_attendance.text.toString(),
        adhoc_attendance.text.toString(),
        adhoc_lab_attendance.text.toString(),
        bd_attendance.text.toString(),
        nsc_attendance.text.toString(),
        dmdw_attendance.text.toString(),
            project_lab_attendance.text.toString(),
        uid,
        username,
        rollNo)

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