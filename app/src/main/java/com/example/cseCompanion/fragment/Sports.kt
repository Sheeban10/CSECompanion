package com.example.cseCompanion.fragment

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.cseCompanion.R
import kotlinx.android.synthetic.main.fragment_sports.view.*

class Sports : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_sports, container, false)

        val imageSlider = view.findViewById<ImageSlider>(R.id.imageSlider)
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel("https://mumbrella.com.au/wp-content/uploads/2017/05/cricket.jpg", "Cricket"))
        imageList.add(SlideModel("https://hdwallpaperim.com/wp-content/uploads/2017/08/23/472881-balls-Table_Tennis.jpg","Table Tennis"))
        imageList.add(SlideModel("https://carrom.in/wp-content/uploads/2019/09/carrom-header-4.jpg","Carrom"))
        imageList.add(SlideModel("http://3.bp.blogspot.com/-Vg00KyCvCsk/TbfCU8lqNoI/AAAAAAAACds/BtZ8qMaSe4w/s1600/Soccer+Football+Wallpapers3.jpg","Football"))


        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        imageSlider.setOnClickListener {
            Toast.makeText(activity,"slider clicked",Toast.LENGTH_SHORT).show()
            Log.d("sports","clicked slider")
        }

        view.imageSlider.setOnClickListener {
           Toast.makeText(activity,"slider clicked",Toast.LENGTH_SHORT).show()
            Log.d("sports","clicked slider")

        }


        view.upcoming_events.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_nav_sports_to_upcoming_events2)
        }

        view.previous_events.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_nav_sports_to_previousEvents)
        }

        view.achievements.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_nav_sports_to_achievements2)
        }

        view.sports_contact.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_nav_sports_to_sportsContact)
        }

        return view
    }


}