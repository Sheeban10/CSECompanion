package com.example.cseCompanion.fragment

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.cseCompanion.R
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_ai_syl.view.*
import kotlinx.android.synthetic.main.fragment_pdf_web_view.*
import kotlinx.android.synthetic.main.fragment_pdf_web_view.view.*
import kotlinx.android.synthetic.main.notice_board_row.view.*
import java.io.File
import java.lang.Exception


class TimeTable6C1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view : View =  inflater.inflate(R.layout.fragment_pdf_web_view, container, false)
        val ref = FirebaseDatabase.getInstance().getReference("8C1")
         ref.get().addOnSuccessListener {
            Log.d("pic",it.toString())
             val uri = it.value.toString()
             Picasso.get().load(uri).into(pic_6c1 , object : Callback{
                 override fun onSuccess() {
                     progressBar_timetable.visibility = View.GONE
                 }

                 override fun onError(e: Exception?) {
                     Toast.makeText(activity,e.toString(),Toast.LENGTH_LONG).show()
                 }

             })
        }

        return view
}}


