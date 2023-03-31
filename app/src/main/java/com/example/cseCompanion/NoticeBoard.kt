package com.example.cseCompanion

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.fragment_notice_board.*
import kotlinx.android.synthetic.main.notice_board_row.view.*
import java.lang.Exception


class NoticeBoard : Fragment() {

    private lateinit var adapter: GroupAdapter<GroupieViewHolder>

    override fun onStart() {
        super.onStart()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_notice_board, container, false)

        //view.noticeboard_progressbar.visibility = View.VISIBLE
        fetchData()
        return view
    }


    private fun fetchData() {
        val ref = FirebaseDatabase.getInstance().getReference("notice")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val adapter = GroupAdapter<GroupieViewHolder>()

                snapshot.children.forEach {
                    Log.d("message", it.toString())
                    val user = it.getValue(User::class.java)
                    if (user != null) {
                        adapter.add(UserItem(user))
                    }
                }

                recyclerview_noticeboard_admin.adapter = adapter
                progressBar_timetable_rc.visibility = View.GONE
                recyclerview_noticeboard_admin.scrollToPosition(adapter.itemCount - 1 )


            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity,"Error! Loading Data",Toast.LENGTH_LONG).show()
            }

        })
    }




}


class UserItem(private val user: User): Item<GroupieViewHolder>(){
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        if (user.imageUrl.isEmpty()){
            viewHolder.itemView.noticeboard_heading.text = user.title
            viewHolder.itemView.notice_time.text = user.date
            viewHolder.itemView.noticeboard_progressbar.visibility = View.GONE
        }else{
            viewHolder.itemView.noticeboard_heading.text = user.title
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


            viewHolder.itemView.image_noticeboard.setOnClickListener {
                val intent = Intent(viewHolder.itemView.context,ImageViewActivity::class.java)
                intent.putExtra("imageUrl",user.imageUrl)
                viewHolder.itemView.context.startActivity(intent)
    }
    }

    override fun getLayout(): Int {
        return R.layout.notice_board_row
    }

}

class User(
    val uid: String,
    val title: String,
    val imageUrl: String,
    val date: String,
    val timestamp: Long
){
    constructor():  this("", "", "", "", -1)
}
