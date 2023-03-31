package com.example.cseCompanion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_image_view.*
import kotlinx.android.synthetic.main.activity_image_view.progressBar_imageView
import kotlinx.android.synthetic.main.activity_image_view_for_notice_board.*
import java.lang.Exception

class ImageViewForNoticeBoard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)

        title = "Gallery"

        val imageUri =  intent.getStringExtra("imageUrl")
        Log.d("imageuri",imageUri.toString())
        gallery_pic
        Picasso.get().load(imageUri).into(notice_pic, object: Callback{
            override fun onSuccess() {
                progressBar_imageViewNotice.visibility = View.GONE
            }

            override fun onError(e: Exception?) {
                Toast.makeText(this@ImageViewForNoticeBoard,e!!.message,Toast.LENGTH_LONG).show()
            }

        })
    }
}