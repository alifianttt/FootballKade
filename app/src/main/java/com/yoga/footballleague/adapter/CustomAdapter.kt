package com.yoga.footballleague.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.res.TypedArray
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.yoga.footballleague.R
import kotlinx.android.synthetic.main.item_league.view.*

class CustomAdapter(private val context: Activity, private val teamName: Array<String>, private val idLeague: Array<String>, private val img: TypedArray): ArrayAdapter<String>(context, R.layout.item_league) {
    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowLayout = inflater.inflate(R.layout.item_league, null, true)

        rowLayout.tv_league.text = teamName[position]
        Glide.with(rowLayout.context)
            .load(img)
            .into(rowLayout.img_league)
        return rowLayout
    }
}