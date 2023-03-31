package com.example.csecompanionadminapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.cseCompanion.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.activity_delete_notice_admin.*
import kotlinx.android.synthetic.main.activity_delete_notice_admin.view.*
import kotlinx.android.synthetic.main.notice_board_row_admin.view.*


class DeleteNotice : AppCompatActivity()  {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_notice_admin)

        supportActionBar?.title = "Delete Notice"

        fetchData()
    }


    private fun fetchData() {
        val ref = FirebaseDatabase.getInstance().getReference("notice")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val adapter = GroupAdapter<GroupieViewHolder>()

                snapshot.children.forEach {
                    Log.d("message", it.toString())
                    val user = it.getValue(User4::class.java)
                    if (user != null) {
                        adapter.add(UserItem(user))
                    }
                }

                recyclerview_noticeboard_admin.adapter = adapter

                noticeboard_progressbar_rc.visibility = View.GONE
                recyclerview_noticeboard_admin.scrollToPosition(adapter.itemCount - 1 )

            }

            override fun onCancelled(error: DatabaseError) {
                noticeboard_progressbar_rc.visibility = View.GONE
                Toast.makeText(this@DeleteNotice,"Error! Loading Data",Toast.LENGTH_LONG).show()
            }

        })
    }




}


class UserItem(private val user: User4): Item<GroupieViewHolder>(){


    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        if (user.imageUrl.isEmpty()){
            viewHolder.itemView.noticeboard_textView.text = user.title
            viewHolder.itemView.notice_time.text = user.date
            viewHolder.itemView.noticeboard_progressbar.visibility = View.GONE
        }else{
            viewHolder.itemView.noticeboard_textView.text = user.title
            viewHolder.itemView.notice_time.text = user.date
            Picasso.get().load(user.imageUrl).into(viewHolder.itemView.image_noticeboard,object : Callback{
                override fun onSuccess() {
                    viewHolder.itemView.noticeboard_progressbar.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                    Log.d("imageview",e.toString())
                }

            })
        }
        viewHolder.itemView.delete_notice.setOnClickListener {

            val builder = AlertDialog.Builder(viewHolder.itemView.context)
            //set title for alert dialog
            builder.setTitle("Permanent Delete")
            //set message for alert dialog
            builder.setMessage("Do you want to delete notice?")
            builder.setIcon(android.R.drawable.ic_dialog_alert)

            //performing positive action
            builder.setPositiveButton("Yes") { dialogInterface, which ->
                FirebaseDatabase.getInstance().getReference("notice").get().addOnSuccessListener {
                    val uid = user.uid
                    Log.d("getId",uid)
                    val remove =   FirebaseDatabase.getInstance().getReference("notice").child(uid).removeValue()

                    viewHolder.itemView.recyclerview_noticeboard_admin.adapter!!.notifyDataSetChanged()
                    Log.d("remove",remove.toString())
                    Toast.makeText(viewHolder.itemView.context,"Record removed",Toast.LENGTH_LONG).show()

                viewHolder.itemView.context.startActivity(Intent(viewHolder.itemView.context,MainActivityAdmin::class.java))
                    val intent = Intent(viewHolder.itemView.context,MainActivityAdmin::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    intent.putExtra("EXIT", true)
                    viewHolder.itemView.context.startActivity(intent)



                }.addOnFailureListener {
                    Toast.makeText(viewHolder.itemView.context,it.message,Toast.LENGTH_LONG).show()
                }

            }
            //performing negative action
            builder.setNegativeButton("No") { dialogInterface, which ->

            }
            // Create the AlertDialog
            val alertDialog: AlertDialog = builder.create()
            // Set other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()



        }

    }

    override fun getLayout(): Int {
        return R.layout.notice_board_row_admin
    }


}

class User4(
    val uid: String,
    val title: String,
    val imageUrl: String,
    val date: String,
    val timestamp: Long
){
    constructor():  this("", "", "", "", -1)
}
