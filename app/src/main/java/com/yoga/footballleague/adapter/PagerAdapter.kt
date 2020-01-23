package com.yoga.footballleague.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.yoga.footballleague.fragment.NextFragment
import com.yoga.footballleague.fragment.PrevFragment

class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                NextFragment()
            }
            else -> {
                return PrevFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Next Match"
            else -> {
                return "Prev Match"
            }
        }
    }
}

