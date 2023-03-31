package com.example.csecompanionadminapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.cseCompanion.AdminLoginProtection
import com.example.cseCompanion.LoginActivity

import com.example.cseCompanion.LoginActivityAdmin
import com.example.cseCompanion.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_main_admin.*
import java.net.PasswordAuthentication

class MainActivityAdmin : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_admin)

//        auth = FirebaseAuth.getInstance()
//
//          FirebaseMessaging.getInstance().subscribeToTopic("Notifications")

        uploadNotice.setOnClickListener {
            startActivity(Intent(this,UploadNotice::class.java))
        }

        gallery.setOnClickListener {
            startActivity(Intent(this,GalleryUpload::class.java))
        }

        send_message.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://console.firebase.google.com/project/cse-companion-bbsbec/notification")))
        }

        update_timetable.setOnClickListener {
            startActivity(Intent(this,SelectTimeTableAdmin::class.java))
        }

        deleteNotice.setOnClickListener {
            startActivity(Intent(this,DeleteNotice::class.java))
        }

        mst_marks.setOnClickListener {
            startActivity(Intent(this,MstMarksAdmin::class.java))
        }

        attendance_upload.setOnClickListener {
            startActivity(Intent(this,AttendanceListAdmin::class.java))
        }

        upcoming_events.setOnClickListener {
            startActivity(Intent(this,UpcomingEventsAdmin::class.java))
        }

        previous_events.setOnClickListener {
            startActivity(Intent(this, PreviousEventsAdmin::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.nav_admin, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings_adm -> {
                val builder = AlertDialog.Builder(this)
                //set title for alert dialog
                builder.setTitle("Log Out")
                //set message for alert dialog
                builder.setMessage("Do you want to logout?")
                builder.setIcon(android.R.drawable.ic_dialog_alert)

                //performing positive action
                builder.setPositiveButton("Yes") { dialogInterface, which ->
                    Toast.makeText(applicationContext, "Logged Out", Toast.LENGTH_LONG).show()
                    auth.signOut()
                    startActivity(Intent(this, LoginActivityAdmin::class.java))
                    finish()
                }
                //performing cancel action
                builder.setNeutralButton("Cancel") { dialogInterface, which ->
                    // Toast.makeText(applicationContext,"clicked cancel\n operation cancel",Toast.LENGTH_LONG).show()
                }
                //performing negative action
                builder.setNegativeButton("No") { dialogInterface, which ->
                    // Toast.makeText(applicationContext,"clicked No",Toast.LENGTH_LONG).show()
                }
                // Create the AlertDialog
                val alertDialog: AlertDialog = builder.create()
                // Set other dialog properties
                alertDialog.setCancelable(false)
                alertDialog.show()
            }

        }
        return super.onOptionsItemSelected(item)
    }

}
