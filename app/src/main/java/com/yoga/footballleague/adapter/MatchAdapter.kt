package com.yoga.footballleague.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yoga.footballleague.R
import com.yoga.footballleague.matchdetail.DetailMatch
import com.yoga.footballleague.model.EventDetail
import kotlinx.android.synthetic.main.item_match.view.*

class MatchAdapter(private val Matchlist: List<EventDetail>):RecyclerView.Adapter<MatchAdapter.holderView>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holderView = holderView(LayoutInflater.from(parent.context).inflate(
        R.layout.item_match, parent, false))

    override fun getItemCount(): Int = Matchlist.size

    override fun onBindViewHolder(holder: holderView, position: Int) {
        holder.bindView(Matchlist[position])
    }

    class holderView(itemView:View): RecyclerView.ViewHolder(itemView) {
        fun bindView(match:EventDetail){
            itemView.tv_name_home.text = match.strHomeTeam
            itemView.tv_name_away.text = match.strAwayTeam
            itemView.tv_date.text = match.dateEvent

            if (match.intHomeScore == null){
                itemView.tv_score_home.text = "0"
            } else{
                itemView.tv_score_home.text = match.intHomeScore
            }

            if (match.intAwayScore == null){
                itemView.tv_score_away.text = "0"
            } else {
                itemView.tv_score_away.text = match.intAwayScore
            }

            itemView.setOnClickListener {
                val intent = Intent(it.context, DetailMatch::class.java).apply {
                    putExtra(DetailMatch.EXTRA_MATCH, match)
                }
                it.context.startActivity(intent)
            }
        }
    }

}