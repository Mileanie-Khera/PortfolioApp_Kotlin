package com.example.myportfolio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class skillsAdapter(private val skillsList : ArrayList<Skills>) :
    RecyclerView.Adapter<skillsAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return skillsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = skillsList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.skillsHeading.text = currentItem.skillHeading
        holder.skillsDescription.text = currentItem.skillDescription
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val skillsHeading : TextView = itemView.findViewById(R.id.Heading)
        val skillsDescription : TextView = itemView.findViewById(R.id.Description)
    }
}