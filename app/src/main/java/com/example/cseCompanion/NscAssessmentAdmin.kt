package com.example.csecompanionadminapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.cseCompanion.R
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_nsc_assessment_admin.*

var marks : Int = 0

class NscAssessment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nsc_assessment_admin)


        setDataToFields()
       // internalCalc()




    }

    private fun internalCalc() {
        val mst1Marks = nsc_marks_m1.text.toString().toInt()
        val mst2Marks = nsc_marks_m2.text.toString().toInt()
        val mst3Marks = nsc_marks_m3.text.toString().toInt()
        var assign1Marks = nsc_assignment_1.text.toString().toInt()
        var assign2Marks = nsc_assignment_2.text.toString().toInt()
        var attendance = nsc_assessment_attendance.text.toString().toInt()

        val myList = mutableListOf(mst1Marks,mst2Marks,mst3Marks)
        print(myList[1])
        Log.d("testing", myList.toString())
    }

    private fun setDataToFields() {

        val uid = intent.getStringExtra("uid")

        val ref1 = FirebaseDatabase.getInstance().getReference("/MST Marks/MST 1/$uid")

        ref1.get().addOnSuccessListener {
            if (it.exists()){
                nsc_marks_m1.text = it.child("nsc").value.toString()
               marks = it.child("nsc").value.toString().toInt()
            }

        }.addOnFailureListener {
            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
        }

        val ref2 = FirebaseDatabase.getInstance().getReference("/MST Marks/MST 2/$uid")

        ref2.get().addOnSuccessListener {
            if (it.exists()){
                nsc_marks_m2.text = it.child("nsc").value.toString()
            }

        }.addOnFailureListener {
            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
        }

        val ref3 = FirebaseDatabase.getInstance().getReference("/MST Marks/MST 3/$uid")

        ref3.get().addOnSuccessListener {
            if (it.exists()){
                nsc_marks_m3.text = it.child("nsc").value.toString()
            }

        }.addOnFailureListener {
            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
        }

        val ref4 = FirebaseDatabase.getInstance().getReference("/Assignments/Assignment 1/$uid")

        ref4.get().addOnSuccessListener {
            if (it.exists()){
                nsc_assignment_1.text = it.child("nsc").value.toString()
            }

        }.addOnFailureListener {
            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
        }

        val ref5 = FirebaseDatabase.getInstance().getReference("/Assignments/Assignment 2/$uid")

        ref5.get().addOnSuccessListener {
            if (it.exists()){
                nsc_assignment_2.text = it.child("nsc").value.toString()
            }

        }.addOnFailureListener {
            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
        }

        val ref6 = FirebaseDatabase.getInstance().getReference("/Attendance/$uid")

        ref6.get().addOnSuccessListener {


            if (it.exists()){
                nsc_assessment_attendance.text = it.child("attendNsc").value.toString()
            }

        }.addOnFailureListener {
            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
        }
        internal_nsc.text = marks.toString()

    }
}