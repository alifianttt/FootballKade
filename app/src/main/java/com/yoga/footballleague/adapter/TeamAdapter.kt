package com.yoga.footballleague.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yoga.footballleague.R
import com.yoga.footballleague.detail.DetailLeague
import com.yoga.footballleague.model.LeagueData
import kotlinx.android.synthetic.main.item_league.view.*

class TeamAdapter(private val league: List<LeagueData>) :
    RecyclerView.Adapter<TeamAdapter.LeagueHolder>() {
    class LeagueHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(get: LeagueData) {
            itemView.tv_league.text = get.leagueName
            Glide.with(itemView.context)
                .load(get.img)
                .into(itemView.img_league)
            itemView.setOnClickListener {
                val intent = Intent(it.context, DetailLeague::class.java).apply {
                    putExtra(DetailLeague.EXTRA_LEAGUE, get)
                }
                it.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LeagueHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_league, parent, false
        )
    )

    override fun getItemCount(): Int {
        return league.size
    }

    override fun onBindViewHolder(holder: LeagueHolder, position: Int) {
        holder.bindView(league[position])
    }
}