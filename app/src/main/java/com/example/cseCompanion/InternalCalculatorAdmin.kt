package com.example.csecompanionadminapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cseCompanion.R
import kotlinx.android.synthetic.main.activity_internal_calculator_admin.*

class InternalCalculatorAdmin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internal_calculator_admin)

        val name =  intent.getStringExtra("username")
        val rollNo = intent.getStringExtra("rollNo")
        val uid = intent.getStringExtra("uid")

        nsc_assessment.setOnClickListener {
            val intent = Intent(this,NscAssessment::class.java)
            intent.putExtra("username",name)
            intent.putExtra("rollNo",rollNo)
            intent.putExtra("uid",uid)
            startActivity(intent)
        }


        dmdw_assessment.setOnClickListener {
            val intent = Intent(this,NscAssessment::class.java)
            intent.putExtra("username",name)
            intent.putExtra("rollNo",rollNo)
            intent.putExtra("uid",uid)
            startActivity(intent)
        }


    }

}