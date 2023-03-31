package com.example.cseCompanion.ui.gallery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cseCompanion.R
import com.google.android.gms.tasks.Task
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ListResult
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_main1.*


class GalleryFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.activity_main1, container, false)

        val storage= FirebaseStorage.getInstance()
        val storageRef=storage.reference.child("gallery")
        val ref = FirebaseDatabase.getInstance().getReference("gallery")
        val imageList: ArrayList <GalleryItem> = ArrayList()
       // view.progressBar.visibility= View.VISIBLE

        val listAllTask: Task<ListResult> = storageRef.listAll()
        listAllTask.addOnCompleteListener{result->
            val items:List<StorageReference> = result.result!!.items

            items.forEachIndexed{index, item->
                item.downloadUrl.addOnSuccessListener {
                    Log.d("item","$it")
                    imageList.add(GalleryItem(it.toString(),System.currentTimeMillis()/1000))
                    gridView.adapter= ImageAdapter(imageList,this)
                    gridView.layoutManager= GridLayoutManager(this.context,3)
                    progressBar.visibility=View.GONE
                }.addOnFailureListener {
                    Toast.makeText(activity,it.message, Toast.LENGTH_LONG).show()
                }
                    //.addOnCompleteListener{
                   // gridView.adapter= ImageAdapter(imageList,this)
                  //  gridView.layoutManager= GridLayoutManager(this.context,3)


                    //progressBar.visibility=View.GONE
               // }
            }
        }

        return view
    }

}