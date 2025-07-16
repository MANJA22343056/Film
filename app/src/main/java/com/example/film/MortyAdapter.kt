package com.example.film

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MortyAdapter(private val dataMorty: List<ResultsItem?>) :
    RecyclerView.Adapter<MortyAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgMorty: ImageView = view.findViewById(R.id.img_card)
        val nameMorty: TextView = view.findViewById(R.id.item_name_morty)
        val statusMorty: TextView = view.findViewById(R.id.descMorty)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_morty, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataMorty?.size ?: 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val mortyItem = dataMorty?.get(position)
        holder.nameMorty.text = mortyItem?.name
        holder.statusMorty.text = mortyItem?.species

        Glide.with(holder.imgMorty.context)
            .load(mortyItem?.image)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imgMorty)

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "${mortyItem?.name}", Toast.LENGTH_SHORT).show()
        }
    }
}
