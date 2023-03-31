package com.example.cseCompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_achievements.view.*
import kotlinx.android.synthetic.main.fragment_sports.view.*


class Achievements : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val view : View =  inflater.inflate(R.layout.fragment_achievements, container, false)

        view.annual_meet.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_achievements2_to_annualMeet)
        }

        return view
    }
}