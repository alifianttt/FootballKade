package com.yoga.footballleague.matchdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.yoga.footballleague.R
import com.yoga.footballleague.model.ClubResponse
import com.yoga.footballleague.model.Clubs
import com.yoga.footballleague.model.EventDetail
import com.yoga.footballleague.model.EventList
import com.yoga.footballleague.repodata.Repository
import kotlinx.android.synthetic.main.activity_detail_match.*

class DetailMatch : AppCompatActivity(), MatchDetailView {

    companion object{
        const val EXTRA_MATCH = "match"
    }

    private lateinit var presenter: MatchDetailPres
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)
        val match = intent.getParcelableExtra(EXTRA_MATCH) as EventDetail
        presenter = MatchDetailPres(this, Repository())

        match.strHomeTeam?.let { presenter.getTeamHome(it) }
        match.strAwayTeam?.let { presenter.getTeamAway(it) }
        showInit(match)
    }

    private fun showInit(item: EventDetail){
        tv_date_match.text = item.dateEvent
        str_gk_home.text = item.strHomeLineupGoalkeeper
        str_def_home.text = item.strHomeLineupDefense
        str_mid_home.text = item.strHomeLineupMidfield
        str_stt_home.text = item.strHomeLineupForward
        str_sub_home.text = item.strHomeLineupSubstitutes

        str_gk_away.text = item.strAwayLineupGoalkeeper
        str_def_away.text = item.strAwayLineupDefense
        str_mid_away.text = item.strAwayLineupMidfield
        str_stt_away.text = item.strAwayLineupForward
        str_sub_away.text = item.strAwayLineupSubstitutes
        if (item.intHomeScore == null){
            score_home_dtl.text = "0"
        } else {
        score_home_dtl.text = item.intHomeScore
        }

        if (item.intAwayScore == null){
            score_away_dtl.text = "0"
        } else {
            score_away_dtl.text = item.intAwayScore
        }

    }

    override fun showBadge(data: ClubResponse?) {
        data?.teams.let {
            val home = it?.get(0)?.strTeamBadge
            Glide.with(applicationContext)
                .load(home)
                .into(bdg_away)
        }
    }

    override fun DataLoad(data: ClubResponse?) {
        data?.teams.let {
            val away = it?.get(0)?.strTeamBadge
            Glide.with(applicationContext)
                .load(away)
                .into(bdg_home)
        }
    }

    override fun onDataError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
