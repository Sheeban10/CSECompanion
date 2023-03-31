package com.example.cseCompanion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_image_view.*
import java.lang.Exception

class ImageViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)

        title = "Notice Board"

       val imageUri =  intent.getStringExtra("imageUrl")
        gallery_pic
        Picasso.get().load(imageUri).into(gallery_pic , object: Callback{
            override fun onSuccess() {
                progressBar_imageView.visibility = View.GONE
            }

            override fun onError(e: Exception?) {
                Toast.makeText(this@ImageViewActivity,e!!.message,Toast.LENGTH_LONG).show()
            }

        })
    }
}