package com.example.cseCompanion.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cseCompanion.R
import kotlinx.android.synthetic.main.others.view.*


class CULinks : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.others, container, false)

        view.cu_website.setOnClickListener {
            val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cusrinagar.edu.in/"))
            startActivity(myIntent)
        }

        view.college_website.setOnClickListener {
            val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://gcetkashmir.ac.in/"))
            startActivity(myIntent)
        }

        view.exam_result.setOnClickListener {
            val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cusrinagar.edu.in/Result/ResultNotification?Program=IH"))
            startActivity(myIntent)
        }

        return view
    }

}