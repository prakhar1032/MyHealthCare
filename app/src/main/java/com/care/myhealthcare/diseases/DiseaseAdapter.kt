package com.care.myhealthcare.diseases

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.care.myhealthcare.R
import kotlinx.android.synthetic.main.disease_view.view.*

class DiseaseAdapter (var list : List<DiseaseInfo>) : RecyclerView.Adapter<DiseaseAdapter.ViewHolder>(){
    class  ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
          val title = view.disease_title
          val description = view.disease_description
        var layout = view.mylayout

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiseaseAdapter.ViewHolder {
      val inflater = LayoutInflater.from(parent.context).inflate(R.layout.disease_view,parent,false)
        return  ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: DiseaseAdapter.ViewHolder, position: Int) {
          holder.title.text = list[position].title
        holder.description.text = list[position].description

        holder.layout.setOnClickListener{
            val intent = Intent(holder.itemView.context,DeleteAndUpdateDiseases::class.java)
            intent.putExtra("id",position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}