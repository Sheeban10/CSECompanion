package com.example.csecompanionadminapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cseCompanion.R
import kotlinx.android.synthetic.main.activity_select_time_table_admin.*

class SelectTimeTableAdmin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_time_table_admin)

        title = "Time Table Upload"

        timetable_6C1.setOnClickListener {
            startActivity(Intent(this,UpdateTimeTable::class.java))
        }
        timetable_6C2.setOnClickListener {
            startActivity(Intent(this,UpdateTt6C2Admin::class.java))
        }
        timetable_6C3.setOnClickListener {
            startActivity(Intent(this,UpdateTt6C3Admin::class.java))
        }

    }
}