package com.yoga.footballleague.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.res.TypedArray
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bumptech.glide.Glide
import com.yoga.footballleague.R
import com.yoga.footballleague.fragment.NextFragment
import com.yoga.footballleague.fragment.PrevFragment
import kotlinx.android.synthetic.main.item_league.view.*

class PagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> {
                NextFragment()
            }
            else ->{
                return PrevFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> "Next Match"
            else ->{
                return "Prev Match"
            }
        }
    }
}

