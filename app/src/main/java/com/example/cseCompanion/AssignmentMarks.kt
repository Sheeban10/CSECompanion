package com.example.cseCompanion

import android.Manifest
import android.app.ProgressDialog
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.cseCompanion.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_assignment_marks.*

import kotlinx.android.synthetic.main.fragment_mst_marks.*
import kotlinx.android.synthetic.main.fragment_mst_marks.view.*
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*


class AssignmentMarks : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val view : View =  inflater.inflate(R.layout.fragment_assignment_marks, container, false)


        val user = FirebaseAuth.getInstance().uid
        Log.d("user",user!!)

        val progressDialog = ProgressDialog(activity)
        progressDialog.setTitle("Loading Marks")
        progressDialog.setMessage("Please wait..")
        progressDialog.show()
        val ref = FirebaseDatabase.getInstance().getReference("Assignments/Assignment 1")
        val ref2 = FirebaseDatabase.getInstance().getReference("Assignments/Assignment 2")

        // assignment marks 1
        ref.child(user).get().addOnSuccessListener {

            val nscMarksM1  = it.child("nsc").value
            assign_marks_nsc1.text = nscMarksM1.toString()

            val dmMarksM1  = it.child("dmdw").value
            assign_marks_dm1.text = dmMarksM1.toString()

            val bdMarksM1  = it.child("bd").value
            assign_marks_bd1.text = bdMarksM1.toString()

            val ddbMarksM1  = it.child("ddb").value
            assign_marks_ddb1.text = ddbMarksM1.toString()

            val adhocMarksM1  = it.child("adhoc").value
            assign_marks_adhoc1.text = adhocMarksM1.toString()

        }.addOnCompleteListener {
            progressDialog.hide()
        }.addOnFailureListener {
            Toast.makeText(activity,it.message, Toast.LENGTH_LONG).show()
        }
        // assignment marks 2
        ref2.child(user).get().addOnSuccessListener {

            val nscMarksM2  = it.child("nsc").value
            assign_marks_nsc2.text = nscMarksM2.toString()

            val dmMarksM2  = it.child("dmdw").value
            assign_marks_dm2.text = dmMarksM2.toString()

            val bdMarksM2  = it.child("bd").value
            assign_marks_bd2.text = bdMarksM2.toString()

            val ddbMarksM2  = it.child("ddb").value
            assign_marks_ddb2.text = ddbMarksM2.toString()

            val adhocMarksM2  = it.child("adhoc").value
            assign_marks_adhoc2.text = adhocMarksM2.toString()


        }.addOnCompleteListener {
            progressDialog.hide()
        }.addOnFailureListener {
            Toast.makeText(activity,it.message, Toast.LENGTH_LONG).show()
        }


        return view
    }

}