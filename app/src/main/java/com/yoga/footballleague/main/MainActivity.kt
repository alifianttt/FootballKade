package com.yoga.footballleague.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoga.footballleague.R
import com.yoga.footballleague.adapter.CustomAdapter
import com.yoga.footballleague.adapter.LeagueAdapter
import com.yoga.footballleague.behave.invisible
import com.yoga.footballleague.model.ClubResponse
import com.yoga.footballleague.model.Clubs
import com.yoga.footballleague.model.LeagueData
import com.yoga.footballleague.repodata.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener, MainView {

    private lateinit var adapter: LeagueAdapter
    private var items: MutableList<LeagueData> = mutableListOf()
    private var clubs : MutableList<Clubs> = mutableListOf()
    private lateinit var idLeague : String
    private lateinit var presenter: MainPresenter
    private lateinit var custom : CustomAdapter
    //private lateinit var spinner: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = resources.getStringArray(R.array.name_list)
        val image = resources.obtainTypedArray(R.array.image_list)
        val idleague = resources.getStringArray(R.array.id_league)
        spin_league.onItemSelectedListener = this
        custom = CustomAdapter(this, name, idleague, image)
        spin_league.adapter = custom
        presenter = MainPresenter(this, Repository())

        //items.clear()

        /*for (i in name.indices){
            items.add(LeagueData(name[i], image.getResourceId(i, 0), idleague[i]))
        }
        Log.d("value ", items.toString())
        image.recycle()*/


        /*spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                idLeague = spin_league.selectedItem.toString()
                presenter.getTeams(idLeague)
            }

        }*/
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

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
                clubs.addAll(it)
            }
            adapter = LeagueAdapter(clubs)
            rv_league.adapter = adapter
            rv_league.layoutManager = LinearLayoutManager(this)
        }
    }

    override fun onDataError() {
        Toast.makeText(applicationContext, "Gagal Load", Toast.LENGTH_SHORT).show()
    }


}



