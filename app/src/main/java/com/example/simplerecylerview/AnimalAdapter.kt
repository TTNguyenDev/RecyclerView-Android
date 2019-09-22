package com.example.simplerecylerview

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.animal_list_item.view.*

class AnimalAdapter(val items: ArrayList<String>, val context: Context): RecyclerView.Adapter<ViewHolder>() {
    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.animal_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvAnimalType.text = items.get(position)
        holder.setItemClickListener(object: ItemClickListener {
            override fun onClick(view: View, position: Int) {
               val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra("nameOfAnimal", items[position])
                context.startActivity(intent)
            }
        })
    }
}

class ViewHolder (view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
    private lateinit var itemClickListener: ItemClickListener

    val tvAnimalType = view.tv_animal_type

    init {
        itemView.setOnClickListener(this)
    }

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    override fun onClick(v: View?) {
        itemClickListener.onClick(v!!, adapterPosition)
    }
}

interface ItemClickListener {
    fun onClick(view: View, position: Int)
}
