package com.example.cseCompanion.ui.gallery

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cseCompanion.ImageViewActivity
import com.example.cseCompanion.R
import com.squareup.picasso.Picasso

class ImageAdapter(private var items: ArrayList<GalleryItem>, private val context: Fragment?):
    RecyclerView.Adapter<ImageAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context!!.context).inflate(
                R.layout.gallery_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val item= items[position]
        Picasso.get().load(item.imageUrl).into(holder.imageView)
        holder.imageView.setOnClickListener {

            val intent = Intent(holder.itemView.context,ImageViewActivity::class.java)
            intent.putExtra("imageUrl",item.imageUrl)
            context!!.startActivity(intent)
            }
    }



    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageView: ImageView =view.findViewById(R.id.imageView)

    }

}