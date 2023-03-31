package com.example.cseCompanion

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.nav_header_main.view.*



class NavActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var auth: FirebaseAuth


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_nav)
        FirebaseMessaging.getInstance().subscribeToTopic("Notifications")

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        auth = FirebaseAuth.getInstance()


        /*   val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }*/
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_gallery,
                R.id.nav_mst_marks,
                R.id.nav_assignment_marks,
                R.id.nav_sports,
                R.id.nav_contact,
                R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        val ref = FirebaseDatabase.getInstance().getReference("users")
        val user = FirebaseAuth.getInstance().uid
        if (user != null) {
            ref.child(user).get().addOnSuccessListener {
                val  username =  it.child("username").value
                navView.getHeaderView(0).header_username.text = "Welcome ${username.toString()}"
            }}



        navView.getHeaderView(0).gmailTextView.setOnClickListener {

            val recipients = arrayOf("coders.strange@gmail.com")
            val gmail = Intent(Intent.ACTION_SEND)
            gmail.putExtra(Intent.EXTRA_EMAIL, recipients)
            gmail.putExtra(Intent.EXTRA_SUBJECT, "CSE Companion App: Suggestion")
            gmail.putExtra(
                Intent.EXTRA_TEXT,
                "*Write your suggestion here! \n *Language doesn't matter \n *Format doesn't matter "
            )
            gmail.type = "text/html"
            gmail.setPackage("com.google.android.gm")
            try {
                startActivity(gmail)
            } catch (e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_SEND))
            }
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.nav, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
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
                    startActivity(Intent(this, LoginActivity::class.java))
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
            R.id.Profile -> {
                Log.d("personal", "fragment ")
                startActivity(Intent(this, Personal::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onSupportNavigateUp(): Boolean {

        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


}


