package com.example.cseCompanion

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_time_table.view.*


class TimeTableFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_time_table, container, false)
      //  view.pfdView.fromAsset("syllabus.pdf").load()

        view.timetable_6C1.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_timeTableFragment_to_pdfWebView)
           // fetchData()
        }

        view.timetable_6C2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_timeTableFragment_to_timeTable6C2)
        }

        view.timetable_6C3.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_timeTableFragment_to_timeTable6C3)
            // fetchData()
        }
        return view
    }}
