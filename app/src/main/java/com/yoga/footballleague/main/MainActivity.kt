package com.yoga.footballleague.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yoga.footballleague.R
import com.yoga.footballleague.fragment.LeagueFragment
import com.yoga.footballleague.fragment.MatchFragment
import com.yoga.footballleague.fragment.TeamFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val onNavItemSelect = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.bt_team -> {
                replaceFragment(TeamFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.bt_match -> {
                replaceFragment(MatchFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.bt_league -> {
                replaceFragment(LeagueFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt_menu.setOnNavigationItemSelectedListener(onNavItemSelect)
        replaceFragment(TeamFragment())


    }


}



