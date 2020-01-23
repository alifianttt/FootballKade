package com.yoga.footballleague.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yoga.footballleague.R
import com.yoga.footballleague.adapter.LeagueAdapter
import com.yoga.footballleague.adapter.PagerAdapter
import com.yoga.footballleague.fragment.LeagueFragment
import com.yoga.footballleague.fragment.MatchFragment
import com.yoga.footballleague.fragment.TeamFragment
import com.yoga.footballleague.model.Clubs
import com.yoga.footballleague.model.LeagueData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: LeagueAdapter
    private var items: MutableList<LeagueData> = mutableListOf()
    private var clubs: MutableList<Clubs> = mutableListOf()
    private lateinit var idLeague: String
    private lateinit var presenter: MainPresenter
    private lateinit var pager: PagerAdapter
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


        //items.clear()

        /*for (i in name.indices){
            items.add(LeagueData(name[i], image.getResourceId(i, 0), idleague[i]))
        }
        Log.d("value ", items.toString())*/


        /*spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                idLeague = spin_league.selectedItem.toString()
                presenter.getTeams(idLeague)
            }

        }*/
    }


    /*override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        idLeague = spin_league.selectedItem.toString()
        presenter.getTeams(idLeague)
    }

    override fun DataLoad(data: ClubResponse?) {
        if (data?.teams == null){
            rv_league.invisible()
        } else {
            data.teams.let {
                clubs.clear()
                clubs.addAll(it)
            }
            adapter = LeagueAdapter(clubs)
            rv_league.adapter = adapter
            rv_league.layoutManager = LinearLayoutManager(this)
        }
    }

    override fun onDataError() {
        Toast.makeText(applicationContext, "Gagal Load", Toast.LENGTH_SHORT).show()
    } */
}



