package com.example.swiggyappdev

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SkillsActivity : AppCompatActivity(){

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Skills>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var description : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skills)

        imageId = arrayOf(
            R.drawable.android,
            R.drawable.angular
        )
        heading = arrayOf(
            "ANDROID",
            "ANGULAR"
        )
        description = arrayOf(
            "Kotlin Java Coroutines MVVM Git Room",
            "HTML CSS Typescript Javascript Bitbucket Postman Figma Jira"
        )

        newRecyclerView = findViewById(R.id.recyclerViewSkills)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        getUserData()
        /*val skillsLayout = findViewById<LinearLayout>(R.id.SkillsLayout)
        val skills = listOf(
            "Android:\n Kotlin Java Coroutines MVVM Git Room",
            "Angular:\n HTML CSS Typescript Javascript Bitbucket Postman Figma Jira"
        )

        for(skill in skills){
            val textView = TextView(this)
            textView.text = skill
            textView.textSize = 17f
            textView.setTextColor(Color.BLUE)
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
            )
            layoutParams.setMargins(0,150,0,0)
            textView.layoutParams = layoutParams
            textView.setPadding(0,8,0,8)
            skillsLayout.addView(textView)
        }*/

    }
    private fun getUserData(){
        for (i in imageId.indices){
            val skill = Skills(imageId[i], heading[i], description[i])
            newArrayList.add(skill)
        }
        newRecyclerView.adapter = skillsAdapter(newArrayList)
    }
}