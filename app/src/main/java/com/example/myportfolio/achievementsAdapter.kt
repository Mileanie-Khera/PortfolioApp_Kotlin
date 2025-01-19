package com.example.myportfolio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class achievementsAdapter (private val achievemenstList : ArrayList<Achievements>):
    RecyclerView.Adapter<achievementsAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return achievemenstList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = achievemenstList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.achievementHeading.text = currentItem.heading
        holder.achievementDate.text = currentItem.date
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val achievementHeading : TextView = itemView.findViewById(R.id.Heading)
        val achievementDate : TextView = itemView.findViewById(R.id.Description)
    }
}