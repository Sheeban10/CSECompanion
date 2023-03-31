package com.example.cseCompanion.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.cseCompanion.R
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ) : View {


        val view: View =  inflater.inflate(R.layout.fragment_home, container, false)

        view.timetable.setOnClickListener {

            Navigation.findNavController(it).navigate(R.id.action_nav_home_to_timeTableFragment)
        }

        view.attendance.setOnClickListener {

            Navigation.findNavController(it).navigate(R.id.action_nav_home_to_attendanceFragment)
        }

        view.noticeBoard.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_nav_home_to_noticeBoard2)
        }

        view.notes.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_nav_home_to_expandableListView)
        }

        view.CU.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_nav_home_to_CULinks)
        }

        view.syllabus.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_nav_home_to_syllabus2)
        }

        return  view
    }
}