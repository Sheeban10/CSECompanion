package com.example.cseCompanion.fragment

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.cseCompanion.R
import kotlinx.android.synthetic.main.fragment_contact_us.*
import kotlinx.android.synthetic.main.fragment_contact_us.view.*
import kotlinx.android.synthetic.main.fragment_contact_us.view.dev_gmail_sir
import kotlinx.android.synthetic.main.fragment_slideshow.view.*
import kotlinx.android.synthetic.main.fragment_sports_contact.view.*


class ContactUs : Fragment() {


    @SuppressLint("IntentReset")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       val view: View =  inflater.inflate(R.layout.fragment_contact_us, container, false)

        view.dev_gmail_sir.setOnClickListener {
            val recipients = arrayOf("wani.nisar@gmail.com")
            val gmail = Intent(Intent.ACTION_SEND)
            gmail.putExtra(Intent.EXTRA_EMAIL,recipients)
            gmail.type = "text/html"
            gmail.setPackage("com.google.android.gm")
            try {
                startActivity(gmail)
            }catch (e: ActivityNotFoundException){
                startActivity(Intent(Intent.ACTION_SEND))
            }
        }


        view.dev_phone_sir.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:+917006262494")
            startActivity(intent)
        }


        view.cse_faculty.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://gcetkashmir.ac.in/academics/departments/computer-science-engineering/")))
        }

        return view
    }


}
