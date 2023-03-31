package com.example.cseCompanion.fragment

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.cseCompanion.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_attendance.*
import kotlinx.android.synthetic.main.fragment_mst_marks.*
import kotlinx.android.synthetic.main.nav_header_main.view.*


class AttendanceFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view : View =  inflater.inflate(R.layout.fragment_attendance, container, false)

        val user = FirebaseAuth.getInstance().uid
        Log.d("user",user!!)
        val ref = FirebaseDatabase.getInstance().getReference("Attendance")
        val progressDialog = ProgressDialog(activity)
        progressDialog.setTitle("Loading data")
        progressDialog.setMessage("Please wait..")
        progressDialog.show()

        ref.child(user).get().addOnSuccessListener {

            val ddbAttend = it.child("attendDdb").value
            ddb_attendance.text = ddbAttend.toString()

            val ddbLab  = it.child("attendDdbLab").value
            DdbLab_attendance.text = ddbLab.toString()

            val adhocAttend = it.child("attendAdhoc").value
            adhoc_attendance.text = adhocAttend.toString()

            val adhocLab  = it.child("attendAdhocLab").value
            AdhocLab_attendance.text = adhocLab.toString()

            val bdAttend = it.child("attendBd").value
            bd_attendance.text = bdAttend.toString()

            val nscLab  = it.child("attendNsc").value
            nsc_attendance.text = nscLab.toString()

            val dwdmAttend = it.child("attendDwdm").value
            dwdm_attendance.text = dwdmAttend.toString()
            
            val projLab  = it.child("attendProjLab").value
            projLab_attendance.text = projLab.toString()


        }.addOnCompleteListener {
            progressDialog.hide()
        }.addOnFailureListener {
            Toast.makeText(activity,it.message, Toast.LENGTH_LONG).show()
        }

        return view
    }


}