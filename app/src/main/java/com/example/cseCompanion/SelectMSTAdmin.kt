package com.example.csecompanionadminapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cseCompanion.R
import kotlinx.android.synthetic.main.activity_select_mst_admin.*

class SelectMSTAdmin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_mst_admin)

        supportActionBar?.title = "Select MST"

        val name =  intent.getStringExtra("username")
        val rollNo = intent.getStringExtra("rollNo")
        val uid = intent.getStringExtra("uid")

        mst1.setOnClickListener {
            val intent = Intent(this,MstMarksUploadAdmin::class.java)
            intent.putExtra("username",name)
            intent.putExtra("rollNo",rollNo)
            intent.putExtra("uid",uid)
            startActivity(intent)
        }

        mst2.setOnClickListener {
            val intent = Intent(this,MarksMst2Admin::class.java)
            intent.putExtra("username",name)
            intent.putExtra("rollNo",rollNo)
            intent.putExtra("uid",uid)
            startActivity(intent)
        }

        mst3.setOnClickListener {
            val intent = Intent(this,MarksMst3Admin::class.java)
            intent.putExtra("username",name)
            intent.putExtra("rollNo",rollNo)
            intent.putExtra("uid",uid)
            startActivity(intent)
        }

        assignment1.setOnClickListener {
            val intent = Intent(this,AssignmentMarksAdmin::class.java)
            intent.putExtra("username",name)
            intent.putExtra("rollNo",rollNo)
            intent.putExtra("uid",uid)
            startActivity(intent)
        }

        assignment2.setOnClickListener {
            val intent = Intent(this,AssignmentMarks2Admin::class.java)
            intent.putExtra("username",name)
            intent.putExtra("rollNo",rollNo)
            intent.putExtra("uid",uid)
            startActivity(intent)
        }

        internalCalc.setOnClickListener {
            val intent = Intent(this,InternalCalculatorAdmin::class.java)
            intent.putExtra("username",name)
            intent.putExtra("rollNo",rollNo)
            intent.putExtra("uid",uid)
            startActivity(intent)
        }

    }

}