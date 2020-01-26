package com.yoga.footballleague.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.yoga.footballleague.fragment.FavoriteFragment
import com.yoga.footballleague.fragment.NextFragment
import com.yoga.footballleague.fragment.PrevFragment

class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                NextFragment()
            }
            1 -> {
                PrevFragment()
            }
            else -> {
                return FavoriteFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Next Match"
            1 -> "Previous Match"
            else -> {
                return "Favorite Match"
            }
        }
    }
}

