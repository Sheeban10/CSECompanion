package com.example.cseCompanion.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import androidx.navigation.Navigation
import com.example.cseCompanion.CustomExpandableListAdapter
import com.example.cseCompanion.ExpandableListData.data
import com.example.cseCompanion.R
import kotlinx.android.synthetic.main.fragment_notes.*
import kotlinx.android.synthetic.main.fragment_notes.view.*
import kotlinx.android.synthetic.main.fragment_syllabus.view.*


class Notes : Fragment() {

    private var expandableListView: ExpandableListView? = null
    private var adapter: ExpandableListAdapter? = null
    private var titleList: List<String>? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view : View =  inflater.inflate(R.layout.fragment_notes, container, false)

        expandableListView = view.findViewById(R.id.expendableList)

        if (expandableListView != null) {
            val listData = data
            titleList = ArrayList(listData.keys)
            adapter = CustomExpandableListAdapter(requireContext(), titleList as ArrayList<String>, listData)
            expandableListView!!.setAdapter(adapter)

            expandableListView!!.setOnChildClickListener { _, _, groupPosition, childPosition, _ ->





                /////////////////////////////////////////////////////////     Compiler Design    ///////////////////////////////////////////////////////////


                if (groupPosition==0 && childPosition==0){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/compiler-introduction"))
                    startActivity(myIntent)
                }
                if (groupPosition==0 && childPosition==1){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/compiler-phases"))
                    startActivity(myIntent)
                }
                if (groupPosition==0 && childPosition==2){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/parser"))
                    startActivity(myIntent)
                }
                if (groupPosition==0 && childPosition==3){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/lr-parser"))
                    startActivity(myIntent)
                }
                if (groupPosition==0 && childPosition==4){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/three-address-code"))
                    startActivity(myIntent)
                }



/////////////////////////////////////////////////////////     Cloud Computing     ///////////////////////////////////////////////////////////




                if (groupPosition==1 && childPosition==0){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/cloud-computing-tutorial"))
                    startActivity(myIntent)
                }
                if (groupPosition==1 && childPosition==1){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/cloud-computing-architecture"))
                    startActivity(myIntent)
                }
                if (groupPosition==1 && childPosition==2){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/cloud-service-models"))
                    startActivity(myIntent)
                }
                if (groupPosition==1 && childPosition==3){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/virtualization-in-cloud-computing"))
                    startActivity(myIntent)
                }
                if (groupPosition==1 && childPosition==4){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/cloud-service-provider-companies"))
                    startActivity(myIntent)
                }

/////////////////////////////////////////////////////////     Artificial Intelligence     ///////////////////////////////////////////////////////////


                if (groupPosition==2 && childPosition==0){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/artificial-intelligence-tutorial"))
                    startActivity(myIntent)
                }
                if (groupPosition==2 && childPosition==1){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/types-of-ai-agents"))
                    startActivity(myIntent)
                }
                if (groupPosition==2 && childPosition==2){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/search-algorithms-in-ai"))
                    startActivity(myIntent)
                }
                if (groupPosition==2 && childPosition==3){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/mini-max-algorithm-in-ai"))
                    startActivity(myIntent)
                }
                if (groupPosition==2 && childPosition==4){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/probabilistic-reasoning-in-artifical-intelligence"))
                    startActivity(myIntent)
                }



/////////////////////////////////////////////////////////     Wireless Communication     ///////////////////////////////////////////////////////////



                if (groupPosition==3 && childPosition==0){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tutorialspoint.com/wireless_communication/wireless_communication_cellular_networks.htm"))
                    startActivity(myIntent)
                }
                if (groupPosition==3 && childPosition==1){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tutorialspoint.com/wireless_communication/wireless_communication_multiple_access.htm"))
                    startActivity(myIntent)
                }
                if (groupPosition==3 && childPosition==2){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tutorialspoint.com/wireless_communication/wireless_communication_tcp_ip.htm"))
                    startActivity(myIntent)
                }
                if (groupPosition==3 && childPosition==3){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tutorialspoint.com/wireless_communication/wireless_communication_propagation_losses.htm"))
                    startActivity(myIntent)
                }
                if (groupPosition==3 && childPosition==4){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tutorialspoint.com/wireless_communication/wireless_communication_bluetooth.htm"))
                    startActivity(myIntent)
                }


////////////////////////////////////////////////////////     Machine Learning     ///////////////////////////////////////////////////////////



                if (groupPosition==4 && childPosition==0){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/machine-learning"))
                    startActivity(myIntent)
                }
                if (groupPosition==4 && childPosition==1){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/regression-analysis-in-machine-learning"))
                    startActivity(myIntent)
                }
                if (groupPosition==4 && childPosition==2){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/simple-linear-regression-in-machine-learning"))
                    startActivity(myIntent)
                }
                if (groupPosition==4 && childPosition==3){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/classification-algorithm-in-machine-learning"))
                    startActivity(myIntent)
                }
                if (groupPosition==4 && childPosition==4){
                    val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/machine-learning-naive-bayes-classifier"))
                    startActivity(myIntent)
                }

                false





            }
        }


        return view
    }

}
