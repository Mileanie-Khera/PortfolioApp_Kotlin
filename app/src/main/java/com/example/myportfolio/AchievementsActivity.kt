package com.example.myportfolio


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AchievementsActivity : AppCompatActivity(){

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Achievements>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var date : Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_achievement)

        imageId = arrayOf(
            R.drawable.cambridge_english,
            R.drawable.nptel,
            R.drawable.nptel,
            R.drawable.nptel,
            R.drawable.nptel
        )
        heading = arrayOf(
            "Cambridge English Entry Level Certificate",
            "Enhancing Soft Skills and Personality",
            "Developing Soft Skills and Personality",
            "Emotional Intelligence",
            "Patent Law for Engineers and Scientists"
        )
        date = arrayOf(
            "March - 2021",
            "Feb - 2021",
            "Jan - 2022",
            "Jul - 2023",
            "Nov - 2024"
        )

        newRecyclerView = findViewById(R.id.recyclerViewAchievements)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        getUserData()
        /*val achievementsLayout = findViewById<LinearLayout>(R.id.AchievementsLayout)
        val achievements = listOf(
            "Cambridge English Entry Level Certificate in ESOL International",
            "NPTEL Certificate – Enhancing Soft Skills and Personality",
            "NPTEL Certificate – Developing Soft Skills and Personality",
            "NPTEL Certificate – Emotional Intelligence",
            "NPTEL Certificate – Patent Law for Engineers and Scientists"
        )

        for(achievement in achievements){
            val textView = TextView(this)
            textView.text = achievement
            textView.textSize = 17f
            textView.setTextColor(Color.BLUE)
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
            )
            layoutParams.setMargins(0,150,0,0)
            textView.layoutParams = layoutParams
            textView.setPadding(0,8,0,8)
            achievementsLayout.addView(textView)
        }*/
    }
    private fun getUserData(){
        for(i in imageId.indices){
            val achievements = Achievements(imageId[i], heading[i], date[i])
            newArrayList.add(achievements)
        }
        newRecyclerView.adapter = achievementsAdapter(newArrayList)
    }
}