package com.example.myportfolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EducationActivity : AppCompatActivity(){
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Education>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var description: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_education)

        imageId = arrayOf(
            R.drawable.btech,
            R.drawable.hsc,
            R.drawable.ssc
        )
        heading = arrayOf(
            "Bachelor of Technology",
            "Higher School Certificate",
            "Secondary School Certificate"
        )
        description = arrayOf(
            "Computer Science and Engineering, 2022, 91.3%",
            "12th, 2018, 94.8%",
            "10th, 2016, 10 CGPA"
        )

        newRecyclerView = findViewById(R.id.recyclerViewEducation)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        getUserData()
        /*val educationLayout = findViewById<LinearLayout>(R.id.EducationLayout)
        val educations = listOf(
            "B.Tech in CSE, 2022, 91.3%",
            "12th, 2018, 94.8%",
            "10th, 2016, 10 CGPA"
        )

        for(education in educations){
            val textView = TextView(this)
            textView.text = education
            textView.textSize = 17f
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(0,150,0,0)
            textView.layoutParams = layoutParams
            textView.setTextColor(Color.BLUE)
            textView.setPadding(0,8,0,8)
            educationLayout.addView(textView)
        }*/
    }
    private fun getUserData(){
        for (i in imageId.indices){
            val education = Education(imageId[i],heading[i],description[i])
            newArrayList.add(education)
        }
        newRecyclerView.adapter = educationAdapter(newArrayList)
    }
}