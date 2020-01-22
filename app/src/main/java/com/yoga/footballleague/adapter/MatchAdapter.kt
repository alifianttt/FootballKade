package com.yoga.footballleague.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yoga.footballleague.R
import com.yoga.footballleague.model.EventDetail
import kotlinx.android.synthetic.main.item_match.view.*

class MatchAdapter(private val Matchlist: List<EventDetail>, private val context:Context):RecyclerView.Adapter<MatchAdapter.holderView>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holderView = holderView(LayoutInflater.from(context).inflate(
        R.layout.item_match, parent, false))

    override fun getItemCount(): Int = Matchlist.size

    override fun onBindViewHolder(holder: holderView, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class holderView(itemView:View): RecyclerView.ViewHolder(itemView) {
        fun bindView(match:EventDetail){
            itemView.name_home.text = match.strHomeTeam
            itemView.name_away.text = match.strAwayTeam

            itemView.date_match.text = match.dateEvent

            if (match.intHomeScore == null){
                itemView.score_home.text = "0"
            } else{
                itemView.score_home.text = match.intHomeScore
            }

            if (match.intAwayScore == null){
                itemView.score_away.text = "0"
            } else {
                itemView.score_away.text = match.intAwayScore
            }
        }
    }

}