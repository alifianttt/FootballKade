package com.yoga.footballleague.detailleague

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.yoga.footballleague.R
import com.yoga.footballleague.model.LeagueData
import com.yoga.footballleague.model.LeagueList
import com.yoga.footballleague.repodata.Repository
import kotlinx.android.synthetic.main.activity_detail_league.*

class DetailLeague : AppCompatActivity(), DetailView {

    companion object {
        const val EXTRA_LEAGUE = "league"
    }

    private lateinit var presenter: DetailPresenter
    private var name: String = ""
    private var desc: String = ""
    private var trophy: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_league)
        val league = intent.getParcelableExtra(EXTRA_LEAGUE) as LeagueData
        presenter = DetailPresenter(this, Repository())
        presenter.getDetail(league.idLeague.toString())

    }

    override fun DataLoad(data: LeagueList?) {
        data?.leagues?.let {
            name = it.get(0).strLeague!!
            desc = it.get(0).strDescriptionEN!!
            trophy = it.get(0).strTrophy.toString()
        }
        Glide.with(applicationContext)
            .load(trophy)
            .into(img_detail_lg)

        tv_name_lg.text = name
        tv_detail_lg.text = desc

    }

    override fun onDataError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
