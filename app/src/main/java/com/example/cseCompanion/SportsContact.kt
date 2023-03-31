package com.example.cseCompanion

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_sports_contact.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SportsContact.newInstance] factory method to
 * create an instance of this fragment.
 */
class SportsContact : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View =  inflater.inflate(R.layout.fragment_sports_contact, container, false)

        view.sports_gmail_sir.setOnClickListener {
            val recipients = arrayOf("hod_cse@bbsbec.ac.in")
            val gmail = Intent(Intent.ACTION_SEND)
            gmail.putExtra(Intent.EXTRA_EMAIL,recipients)
            gmail.type = "text/html"
            gmail.setPackage("com.google.android.gm")
            try {
                startActivity(gmail)
            }catch (e: ActivityNotFoundException){
                startActivity(Intent(Intent.ACTION_SEND))
            }
        }


        view.sports_phone_sir.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:+917006710526")
            startActivity(intent)
        }


        return view
    }

    companion object {



        fun newInstance(param1: String, param2: String) =
            SportsContact().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}