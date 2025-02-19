package com.example.myportfolio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class educationAdapter(private val educationList : ArrayList<Education>) :
    RecyclerView.Adapter<educationAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return educationList.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = educationList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.heading.text = currentItem.heading
        holder.description.text = currentItem.description
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        var heading : TextView = itemView.findViewById(R.id.Heading)
        var description : TextView = itemView.findViewById(R.id.Description)
    }
}