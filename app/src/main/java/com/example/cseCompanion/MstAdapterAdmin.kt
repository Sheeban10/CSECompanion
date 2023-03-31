package com.example.csecompanionadminapp

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cseCompanion.R
import com.example.csecompanionadminapp.model.User
import kotlinx.android.synthetic.main.mst_items_admin.view.*

class MstAdapterAdmin (private val userList : ArrayList<User>): RecyclerView.Adapter<MstAdapterAdmin.MyViewHolder>()   {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
         val itemView = LayoutInflater.from(parent.context).inflate(
             R.layout.mst_items_admin,
         parent,false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]


        holder.username.text = currentItem.username
        holder.collRoll.text = currentItem.collRollNo
        val uid = currentItem.uid.toString()
        Log.d("UID:",uid)

        holder.itemView.user_cardView.setOnClickListener {
            Log.d("onClick","cardView")
            Log.d("uid",uid)
            //holder.itemView.context.startActivity(Intent(holder.itemView.context,MstMarksUpload::class.java))
            val intent = Intent(holder.itemView.context,SelectMSTAdmin::class.java)
            intent.putExtra("username",currentItem.username)
            intent.putExtra("rollNo",currentItem.collRollNo)
            intent.putExtra("uid",currentItem.uid)
            holder.itemView.context.startActivity(intent)

        }




    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val username : TextView = itemView.findViewById(R.id.tv_username)
        val collRoll : TextView = itemView.findViewById(R.id.tv_rollNo)


    }
}