package com.example.csecompanionadminapp

import android.app.ProgressDialog
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.cseCompanion.R
import com.example.csecompanionadminapp.model.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*
import kotlin.collections.ArrayList

class AttendanceListAdmin : AppCompatActivity() {

    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<User>
    private lateinit var tempArrayList: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance_list_admin)

        supportActionBar?.title = "Student List"

        userRecyclerView = findViewById(R.id.attendanceList_rv)
        userRecyclerView.hasFixedSize()

        userArrayList = arrayListOf()
        tempArrayList = arrayListOf()
        getUserData()


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_item_admin, menu)
        val item = menu.findItem(R.id.search_action)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                tempArrayList.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())

                if (searchText.isNotEmpty()){
                    userArrayList.forEach {
                        if (it.collRollNo!!.contains(searchText) || it.username!!.toLowerCase(Locale.getDefault()).contains(searchText)){
                            tempArrayList.add(it)
                        }
                    }
                    userRecyclerView.adapter!!.notifyDataSetChanged()


                }


                else{
                    tempArrayList.clear()
                    tempArrayList.addAll(userArrayList)
                    userRecyclerView.adapter!!.notifyDataSetChanged()
                }

                return false
            }

        })

        return super.onCreateOptionsMenu(menu)
    }

    private fun getUserData() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Student List")
        progressDialog.setMessage("List is loading, please wait")
        progressDialog.show()
        val ref = FirebaseDatabase.getInstance().getReference("users")
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){

                    for (userSnapshot in snapshot.children){
                        val user = userSnapshot.getValue(User::class.java)
                        userArrayList.add(user!!)
                        tempArrayList.add(user)
                    }

                    userRecyclerView.adapter = AttendanceAdapterAdmin(tempArrayList)

                    progressDialog.hide()

                }
            }


            override fun onCancelled(error: DatabaseError) {
                progressDialog.hide()
                Toast.makeText(this@AttendanceListAdmin,error.message,Toast.LENGTH_LONG).show()
            }

        })
    }

}