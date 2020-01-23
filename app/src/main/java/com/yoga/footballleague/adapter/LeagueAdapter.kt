package com.yoga.footballleague.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yoga.footballleague.R
import com.yoga.footballleague.model.Clubs
import kotlinx.android.synthetic.main.item_league.view.*

class LeagueAdapter(private val clubs: List<Clubs>) : RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindView(get:Clubs){
            itemView.tv_league.text = get.teamName
            Glide.with(itemView.context)
                .load(get.strTeamBadge)
                .into(itemView.img_league)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.item_league, parent, false
    ))

    override fun getItemCount(): Int {
        return clubs.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(clubs[position])
    }
}