package com.example.cseCompanion.ui.slideshow

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cseCompanion.R
import kotlinx.android.synthetic.main.fragment_slideshow.view.*

class SlideshowFragment : Fragment() {

    @SuppressLint("IntentReset")
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_slideshow, container, false)



    //////////////////////////////// Sheeban Fareedi /////////////////////////////////////////

        view.dev_insta_sheeban.setOnClickListener {
            val uri = Uri.parse("https://www.instagram.com/sheeban_fareedi/")
            val instagram = Intent(Intent.ACTION_VIEW, uri)
            instagram.setPackage("com.instagram.android")
            try {
                startActivity(instagram)
            }catch (e: ActivityNotFoundException){
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/sheeban_fareedi/")))
            }
        }

        view.dev_gmail_sheeban.setOnClickListener {
            val recipients = arrayOf("sheebanfareedi@gmail.com")
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

        view.dev_linkdin_sheeban.setOnClickListener {
            val uri = Uri.parse("https://www.linkedin.com/in/sheeban-fareedi-b6748b171/")
            val linkedin = Intent(Intent.ACTION_VIEW,uri)
            linkedin.setPackage("com.linkedin.android")
            try {
                startActivity(linkedin)
            }catch (e: ActivityNotFoundException){
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/sheeban-fareedi-b6748b171/")))
            }
        }

        view.dev_github_sheeban.setOnClickListener {
            val uri = Uri.parse("https://github.com/Sheeban10")
            val github = Intent(Intent.ACTION_VIEW,uri)
            github.setPackage("com.github.android")
            try {
                startActivity(github)
            }catch (e: ActivityNotFoundException){
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Sheeban10")))
            }
        }

   //////////////////////// //Umar Mukhtar///////////////////////////////////////////////////

        view.dev_insta_umar.setOnClickListener {
            val uri = Uri.parse("https://www.instagram.com/umar_makhdoomi/")
            val instagram = Intent(Intent.ACTION_VIEW, uri)
            instagram.setPackage("com.instagram.android")
            try {
                startActivity(instagram)
            }catch (e: ActivityNotFoundException){
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/umar_makhdoomi/")))
            }
        }

        view.dev_gmail_umar.setOnClickListener {
            val recipients = arrayOf("umarmakhdoomi007@gmail.com")
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

        view.dev_linkdin_umar.setOnClickListener {
            val uri = Uri.parse("https://www.linkedin.com/in/umar-makhdoomi-55ba871b8/")
            val linkedin = Intent(Intent.ACTION_VIEW,uri)
            linkedin.setPackage("com.linkedin.android")
            try {
                startActivity(linkedin)
            }catch (e: ActivityNotFoundException){
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/umar-makhdoomi-55ba871b8/")))
            }
        }

        view.dev_github_umar.setOnClickListener {
            val uri = Uri.parse("https://github.com/UmarMakhdoomi/")
            val github = Intent(Intent.ACTION_VIEW,uri)
            github.setPackage("com.github.android")
            try {
                startActivity(github)
            }catch (e: ActivityNotFoundException){
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/UmarMakhdoomi/")))
            }
        }
        ////////////////////////// Nida Malik Developer Details //////////////////////////////
        view.dev_gmail_nida_malik.setOnClickListener {
            val recipients = arrayOf("maliknidanm25@gmail.com")
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

        view.dev_linkdin_nida_malik.setOnClickListener {
            val uri = Uri.parse("https://www.linkedin.com/in/nida -malik-216484248/")
            val linkedin = Intent(Intent.ACTION_VIEW,uri)
            linkedin.setPackage("com.linkedin.android")
            try {
                startActivity(linkedin)
            }catch (e: ActivityNotFoundException){
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/nida -malik-216484248/")))
            }
        }


        ////////////////////////// Adeeba ///////////////////////////////////
        view.dev_gmail_adeeba.setOnClickListener {
            val recipients = arrayOf("bhatada6@gmail.com")
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


        ////////////////////////// Nida Nabi ///////////////////////////////////
        view.dev_gmail_nida_nabi.setOnClickListener {
            val recipients = arrayOf("nidanabi123@gmail.com")
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


        return view
    }
}