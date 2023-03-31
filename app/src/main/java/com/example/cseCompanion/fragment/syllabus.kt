package com.example.cseCompanion.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.cseCompanion.R
import kotlinx.android.synthetic.main.fragment_syllabus.view.*


class syllabus : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_syllabus, container, false)

        view.syllabus_ai.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_syllabus2_to_ai_syl)
        }

        view.syllabus_cc.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_syllabus2_to_ccSyllabus)
        }

        view.syllabus_cd.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_syllabus2_to_cdSyllabus)
        }

        view.syllabus_ml.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_syllabus2_to_mlSyllabus)
        }

        view.syllabus_wc.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_syllabus2_to_wcSyllabus)
        }
        return view
    }
}
