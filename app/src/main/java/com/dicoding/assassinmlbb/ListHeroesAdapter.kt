package com.dicoding.assassinmlbb

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListHeroesAdapter(private val listHeroes: ArrayList<Heroes>) :
    RecyclerView.Adapter<ListHeroesAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_heroes, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val heroes = listHeroes[position]
        Glide.with(holder.itemView.context)
            .load(heroes.photo)
            .into(holder.imgPhoto)
        holder.tvName.text = heroes.name
        holder.tvDescription.text = heroes.description
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailHeroesActivity::class.java)
            intent.putExtra(DetailHeroesActivity.EXTRA_NAME, heroes.name)
            intent.putExtra(DetailHeroesActivity.EXTRA_DESCRIPTION, heroes.description)
            intent.putExtra(DetailHeroesActivity.EXTRA_PHOTO, heroes.photo)
            intent.putExtra(DetailHeroesActivity.EXTRA_ROLE, heroes.role)
            intent.putExtra(DetailHeroesActivity.EXTRA_TAHUN_RILIS, heroes.tahunRilis)
            intent.putExtra(DetailHeroesActivity.EXTRA_URUT_HERO, heroes.urutHero)
            intent.putExtra(DetailHeroesActivity.EXTRA_SEJARAH_SINGKAT, heroes.sejarahSingkat)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listHeroes.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }


}