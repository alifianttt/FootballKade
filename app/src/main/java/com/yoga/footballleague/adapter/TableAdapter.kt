package com.yoga.footballleague.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yoga.footballleague.R
import com.yoga.footballleague.model.EventDetail
import com.yoga.footballleague.model.TableItem
import kotlinx.android.synthetic.main.item_table.view.*

class TableAdapter(private val table: List<TableItem>,private val listener: (TableItem)-> Unit): RecyclerView.Adapter<TableAdapter.TableHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableHolder = TableHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_table, parent, false)
    )

    override fun getItemCount(): Int = table.size

    override fun onBindViewHolder(holder: TableHolder, position: Int) {
        holder.bindtable(table[position], listener)
    }

    class TableHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindtable(tableItem: TableItem, listener: (TableItem) -> Unit){
            itemView.tv_name.text = tableItem.name
            itemView.tv_play.text = tableItem.played
            itemView.tv_win.text = tableItem.win
            itemView.tv_draw.text = tableItem.draw
            itemView.tv_lose.text = tableItem.loss
            itemView.tv_gf.text = tableItem.goalsfor
            itemView.tv_ga.text = tableItem.goalsagainst
            itemView.tv_gd.text = tableItem.goalsdifference
            itemView.setOnClickListener {
                listener(tableItem)
            }
        }

    }
}