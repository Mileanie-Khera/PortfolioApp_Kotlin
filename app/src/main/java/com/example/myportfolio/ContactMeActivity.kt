package com.example.myportfolio

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ContactMeActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_me)

        // Finding ImageViews for social media icons
        val linkedinIcon: ImageView = findViewById(R.id.linkedinIcon)
        val instagramIcon: ImageView = findViewById(R.id.instagramIcon)
        val facebookIcon: ImageView = findViewById(R.id.facebookIcon)

        // Setting OnClickListener for LinkedIn icon
        linkedinIcon.setOnClickListener {
            openUrl("https://www.linkedin.com/in/mileanie-khera/")
        }

        // Setting OnClickListener for Instagram icon
        instagramIcon.setOnClickListener {
            openUrl("https://www.instagram.com/milliekhera/")
        }

        // Setting OnClickListener for Facebook icon
        facebookIcon.setOnClickListener {
            openUrl("https://www.facebook.com/mileanie.khera/")
        }
    }

    // Method to open URL in browser
    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}