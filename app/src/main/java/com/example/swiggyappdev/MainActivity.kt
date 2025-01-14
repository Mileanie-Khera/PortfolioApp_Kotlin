package com.example.swiggyappdev

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.google.android.material.switchmaterial.SwitchMaterial
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val nightMode = AppCompatDelegate.getDefaultNightMode()
        setTheme(
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) R.style.AppTheme_Dark
            else R.style.AppTheme_Light
        )

        val buttonSkills = findViewById<Button>(R.id.skillsButton)
        val buttonExperience = findViewById<Button>(R.id.experienceButton)
        val buttonEducation = findViewById<Button>(R.id.educationButton)
        val buttonAchievement = findViewById<Button>(R.id.achievementButton)
        val switchDarkMode = findViewById<SwitchMaterial>(R.id.DarkMode)
        val textName = findViewById<TextView>(R.id.Name)
        val textDesignation = findViewById<TextView>(R.id.Designation)
        val buttonContactMe = findViewById<Button>(R.id.contactMe)

        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            textName.setTextColor(ContextCompat.getColor(this, R.color.white))
            textDesignation.setTextColor(ContextCompat.getColor(this, R.color.white))
            buttonSkills.setTextColor(ContextCompat.getColor(this, R.color.buttonTextColorDark))
            buttonEducation.setTextColor(ContextCompat.getColor(this, R.color.buttonTextColorDark))
            buttonAchievement.setTextColor(ContextCompat.getColor(this, R.color.buttonTextColorDark))
            buttonExperience.setTextColor(ContextCompat.getColor(this, R.color.buttonTextColorDark))

        }else{
            textName.setTextColor(ContextCompat.getColor(this, R.color.blue))
            textDesignation.setTextColor(ContextCompat.getColor(this, R.color.blue))
            buttonSkills.setTextColor(ContextCompat.getColor(this, R.color.buttonTextColorLight))
            buttonEducation.setTextColor(ContextCompat.getColor(this, R.color.buttonTextColorLight))
            buttonAchievement.setTextColor(ContextCompat.getColor(this, R.color.buttonTextColorLight))
            buttonExperience.setTextColor(ContextCompat.getColor(this, R.color.buttonTextColorLight))

        }
        switchDarkMode.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked){
                AppCompatDelegate.setDefaultNightMode((AppCompatDelegate.MODE_NIGHT_YES))
            }else{
                AppCompatDelegate.setDefaultNightMode((AppCompatDelegate.MODE_NIGHT_NO))
            }
        }
        buttonSkills.setOnClickListener{
            intent = Intent(this, SkillsActivity::class.java)
            startActivity(intent)
        }

        buttonExperience.setOnClickListener{
            intent = Intent(this, ExperienceActivity::class.java)
            startActivity(intent)
        }

        buttonEducation.setOnClickListener{
            intent = Intent(this, EducationActivity::class.java)
            startActivity(intent)
        }

        buttonAchievement.setOnClickListener{
            intent = Intent(this, AchievementsActivity::class.java)
            startActivity(intent)
        }

        buttonContactMe.setOnClickListener{
            intent = Intent(this, ContactMeActivity::class.java)
            startActivity(intent)
        }
    }
}