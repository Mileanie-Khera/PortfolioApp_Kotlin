package com.example.myportfolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExperienceActivity : AppCompatActivity(){
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Experience>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var description: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experience)

        imageId = arrayOf(
            R.drawable.manulife,
            R.drawable.manulife,
            R.drawable.kotak
        )
        heading = arrayOf(
            "Singapore Manulife",
            "Hong Kong Manulife",
            "Kotak Mahindra Life Insurance"
        )
        description = arrayOf(
            "Frontend Web and Android developer, Jan 2023 - Aug 2023",
            "Frontend Web and Android developer, Aug 2023 - March 2024",
            "Frontend Web and Android developer, Aug 2024 - Present"
        )

        newRecyclerView = findViewById(R.id.recyclerViewExperience)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        getUserData()
        /*val experienceLayout = findViewById<LinearLayout>(R.id.ExperienceLayout)
        val experiences = listOf(
            "Frontend Web and Android developer, Singapore Manulife\nJan 2023 - Aug 2023",
            "Frontend Web developer, Hong Kong Manulife\nAug 2023 - March 2024",
            "Frontend Web and Android developer, Kotak Mahindra Life Insurance\nAug 2024 - Present",
        )

        for(experience in experiences){
            val textView = TextView(this)
            textView.text = experience
            textView.textSize = 17f
            textView.setTextColor(Color.BLUE)
             val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
            )
            layoutParams.setMargins(0,150,0,0)
            textView.layoutParams = layoutParams
            textView.setPadding(0,8,0,8)
            experienceLayout.addView(textView)
        }*/
    }
    private fun getUserData(){
        for(i in imageId.indices){
            val experience = Experience(imageId[i], heading[i], description[i])
            newArrayList.add(experience)
        }
        newRecyclerView.adapter = experienceAdapter(newArrayList)
    }
}