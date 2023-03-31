package com.example.cseCompanion

import java.util.*
internal object ExpandableListData {
    val data: HashMap<String, List<String>>
        get() {
            val expandableListDetail =
                HashMap<String, List<String>>()


            val cd: MutableList<String> = ArrayList()
            cd.add("Introduction to Compiler")
            cd.add("Compiler Phases")
            cd.add("Parser")
            cd.add("LR Parser")
            cd.add("Three address code")

            val cc: MutableList<String> = ArrayList()
            cc.add("Cloud Computing Tutorial")
            cc.add("Cloud Computing Architecture")
            cc.add("Cloud Service Models")
            cc.add("Virtualization")
            cc.add("Cloud Service Provider Companies")

            val ai: MutableList<String> = ArrayList()
            ai.add("What is Artificial Intelligence")
            ai.add("Types of AI Agents")
            ai.add("Search Algorithms")
            ai.add("Mini-Max Algorithm")
            ai.add("Probabilistic reasoning")

            val wc: MutableList<String> = ArrayList()
            wc.add("Cellular Systems")
            wc.add("Multiple Access Techniques")
            wc.add("Wireless Communication - TCP/IP")
            wc.add("Propagation Losses")
            wc.add("Bluetooth")

            val ml: MutableList<String> = ArrayList()
            ml.add("What is Machine Learning")
            ml.add("Regression Analysis ")
            ml.add("Simple Linear Regression")
            ml.add("Classification Algorithm")
            ml.add("Naïve Bayes Classifier Algorithm")


            expandableListDetail["Compiler Design"] = cd
            expandableListDetail["Artificial Intelligence"] = ai
            expandableListDetail["Cloud Computing"] = cc
            expandableListDetail["Wireless Communication"] = wc
            expandableListDetail["Machine Learning"] = ml


            return expandableListDetail
        }
}