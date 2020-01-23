package com.yoga.footballleague.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yoga.footballleague.R
import com.yoga.footballleague.model.FavoriteMatch
import kotlinx.android.synthetic.main.item_match.view.*

class FavoriteAdapter(private val favorite: List<FavoriteMatch>): RecyclerView.Adapter<FavoriteAdapter.FavoriteHolder>() {
    class FavoriteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(get:FavoriteMatch){
            itemView.tv_name_home.text = get.teamHomeName
            itemView.tv_name_away.text = get.teamAwayName
            itemView.tv_score_home.text = get.scoreHome
            itemView.tv_score_away.text = get.scoreAway
            itemView.tv_date.text = get.dateMatch
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteHolder = FavoriteHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false))

    override fun getItemCount(): Int = favorite.size

    override fun onBindViewHolder(holder: FavoriteHolder, position: Int) {
        holder.bindView(favorite[position])
    }
}