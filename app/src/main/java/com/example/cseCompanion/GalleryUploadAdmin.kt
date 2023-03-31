package com.example.csecompanionadminapp

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.cseCompanion.R
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_gallery_upload_admin.*
import kotlinx.android.synthetic.main.activity_upload_notice_admin.progressBar
import java.util.*

@Suppress("DEPRECATION")
class GalleryUpload : AppCompatActivity() {

    private val pickImage = 100
    private var imageUri: Uri? = null




    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_upload_admin)

        title = "Gallery Image Upload"

        addImageGallery.setOnClickListener {
            openGallery()
        }

        uploadGalleryButton.setOnClickListener {

            if (imageUri != null) {
                progressBar.visibility = View.VISIBLE
                uploadImage()
            }

        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun uploadImage() {
        if (imageUri == null) return
       // val filename = UUID.randomUUID().toString()
        val timestamp = System.currentTimeMillis()/1000
        val ref = FirebaseStorage.getInstance().getReference("/gallery/$timestamp")

        ref.putFile(imageUri!!)
                .addOnSuccessListener { it ->
                    Log.d("upload","Successfully uploaded : ${it.metadata?.path}")

                    ref.downloadUrl.addOnSuccessListener {
                        Log.d("Upload","File Location: $it")

                        saveDataToFirebaseRealtimeDatabase(it.toString())
                    }.addOnFailureListener {
                        Toast.makeText(this,it.message,Toast.LENGTH_LONG).show()
                    }
                }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun saveDataToFirebaseRealtimeDatabase(imageUrl: String) {

        val ref =  FirebaseDatabase.getInstance().getReference("/gallery").push()



        val user  = User1(ref.key!!,imageUrl, System.currentTimeMillis()/1000)

        ref.setValue(user)
                .addOnSuccessListener {
                    progressBar.visibility = View.GONE
                    Log.d("upload","Data Saved to database")
                    Toast.makeText(this,"Data Uploaded Successfully",Toast.LENGTH_LONG).show()
                }.addOnFailureListener {
                progressBar.visibility = View.GONE
                Toast.makeText(this,it.message,Toast.LENGTH_LONG).show()
            }
    }


    private fun openGallery(){
        val intent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        startActivityForResult(intent,pickImage)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == pickImage && resultCode == RESULT_OK){
            imageUri = data?.data
            GalleryImageView.setImageURI(imageUri)
        }
    }
}
class User1(val uid: String, val imageUrl: String, val timestamp: Long)
