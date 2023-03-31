package com.example.cseCompanion.fragment

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

import kotlinx.android.synthetic.main.fragment_mst_marks.*
import kotlinx.android.synthetic.main.fragment_mst_marks.view.*
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*


class MstMarks : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val view : View =  inflater.inflate(R.layout.fragment_mst_marks, container, false)


        val user = FirebaseAuth.getInstance().uid
        Log.d("user",user!!)

        val progressDialog = ProgressDialog(activity)
        progressDialog.setTitle("Loading Marks")
        progressDialog.setMessage("Please wait..")
        progressDialog.show()
        val ref = FirebaseDatabase.getInstance().getReference("MST Marks/MST 1")
        val ref2 = FirebaseDatabase.getInstance().getReference("MST Marks/MST 2")
        val ref3 = FirebaseDatabase.getInstance().getReference("MST Marks/MST 3")

        // mst marks 1
        ref.child(user).get().addOnSuccessListener {

            val nscMarksM1  = it.child("nsc").value
            nsc_marks_m1.text = nscMarksM1.toString()

            val dmMarksM1  = it.child("dmdw").value
            dm_marks_m1.text = dmMarksM1.toString()

            val bdMarksM1  = it.child("bd").value
            bd_marks_m1.text = bdMarksM1.toString()

            val ddbMarksM1  = it.child("ddb").value
            ddb_marks_m1.text = ddbMarksM1.toString()

            val adhocMarksM1  = it.child("adhoc").value
            adhoc_marks_m1.text = adhocMarksM1.toString()

        }.addOnCompleteListener {
           progressDialog.hide()
        }.addOnFailureListener {
            Toast.makeText(activity,it.message, Toast.LENGTH_LONG).show()
        }
        // mst marks 2
        ref2.child(user).get().addOnSuccessListener {

            val nscMarksM2  = it.child("nsc").value
            nsc_marks_m2.text = nscMarksM2.toString()

            val dmMarksM2  = it.child("dmdw").value
            dm_marks_m2.text = dmMarksM2.toString()

            val bdMarksM2  = it.child("bd").value
            bd_marks_m2.text = bdMarksM2.toString()

            val ddbMarksM2  = it.child("ddb").value
            ddb_marks_m2.text = ddbMarksM2.toString()

            val adhocMarksM2  = it.child("adhoc").value
            adhoc_marks_m2.text = adhocMarksM2.toString()


        }.addOnCompleteListener {
            progressDialog.hide()
        }.addOnFailureListener {
            Toast.makeText(activity,it.message, Toast.LENGTH_LONG).show()
        }

        // mst marks 3
        ref3.child(user).get().addOnSuccessListener {

            val nscMarksM3  = it.child("nsc").value
            nsc_marks_m3.text = nscMarksM3.toString()

            val dmMarksM3  = it.child("dmdw").value
            dm_marks_m3.text = dmMarksM3.toString()

            val bdMarksM3  = it.child("bd").value
            bd_marks_m3.text = bdMarksM3.toString()

            val ddbMarksM3  = it.child("ddb").value
            ddb_marks_m3.text = ddbMarksM3.toString()

            val adhocMarksM3  = it.child("adhoc").value
            adhoc_marks_m3.text = adhocMarksM3.toString()

        }.addOnCompleteListener {
            progressDialog.hide()
        }.addOnFailureListener {
            Toast.makeText(activity,it.message, Toast.LENGTH_LONG).show()
        }


        return view
    }

}