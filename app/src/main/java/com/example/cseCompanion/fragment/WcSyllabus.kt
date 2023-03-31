package com.example.cseCompanion.fragment

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.cseCompanion.R
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.fragment_ai_syl.*
import kotlinx.android.synthetic.main.fragment_ai_syl.view.*
import kotlinx.android.synthetic.main.fragment_ai_syl.view.ai_pfdView
import kotlinx.android.synthetic.main.fragment_cc_syllabus.view.*
import kotlinx.android.synthetic.main.fragment_cc_syllabus.view.cc_pfdView
import kotlinx.android.synthetic.main.fragment_pdf_web_view.view.*
import kotlinx.android.synthetic.main.fragment_wc_syllabus.view.*
import java.io.File


class WcSyllabus : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view : View =  inflater.inflate(R.layout.fragment_wc_syllabus, container, false)
        val fileRef = FirebaseStorage.getInstance().getReference("/syllabus/syllabus.pdf")

        val localFile = File.createTempFile("wcSyllabus", ".pdf")
        fileRef.getFile(localFile)
            .addOnSuccessListener {
                view.wc_pfdView.fromFile(localFile)
                    .pages(83,84,85)
                    .load()
                view.wc_progressBar.visibility = View.GONE
            }.addOnFailureListener {
                Toast.makeText(activity,it.message,Toast.LENGTH_LONG).show()
            }
        return view
    }}


