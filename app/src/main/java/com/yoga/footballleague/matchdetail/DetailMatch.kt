package com.yoga.footballleague.matchdetail

import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.yoga.footballleague.R
import com.yoga.footballleague.R.drawable.ic_add_to_fav
import com.yoga.footballleague.R.drawable.ic_added_fav
import com.yoga.footballleague.db.database
import com.yoga.footballleague.model.*
import com.yoga.footballleague.repodata.Repository
import kotlinx.android.synthetic.main.activity_detail_match.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class DetailMatch : AppCompatActivity(), MatchDetailView {

    private var menuItem: Menu? = null
    private var isFav: Boolean = false
    private lateinit var nameAway: String
    private lateinit var nameHome: String
    private lateinit var id: String
    private lateinit var presenter: MatchDetailPres
    private lateinit var match: EventDetail
    private lateinit var badge: Clubs
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)
        val intent = intent
        id = intent.getStringExtra("id")
        nameAway = intent.getStringExtra("nameAway")
        nameHome = intent.getStringExtra("nameHome")
        presenter = MatchDetailPres(this, Repository())
        listFav()
        presenter.getTeamHome(nameHome)
        presenter.getTeamAway(nameAway)
        presenter.getEvent(id)

    }


    override fun getEvent(data: EventList?) {
        data?.events.let {
            match = EventDetail(
                it?.get(0)?.idEvent,
                it?.get(0)?.strHomeTeam,
                it?.get(0)?.strAwayTeam,
                it?.get(0)?.dateEvent,
                it?.get(0)?.intHomeScore,
                it?.get(0)?.intAwayScore,
                it?.get(0)?.strHomeLineupGoalkeeper,
                it?.get(0)?.strHomeLineupDefense,
                it?.get(0)?.strHomeLineupMidfield,
                it?.get(0)?.strHomeLineupForward,
                it?.get(0)?.strHomeLineupSubstitutes,
                it?.get(0)?.strAwayLineupGoalkeeper,
                it?.get(0)?.strAwayLineupDefense,
                it?.get(0)?.strAwayLineupMidfield,
                it?.get(0)?.strAwayLineupForward,
                it?.get(0)?.strAwayLineupSubstitutes,
                it?.get(0)?.strSport
            )
            tv_date_match.text = it?.get(0)?.dateEvent
            str_gk_home.text = it?.get(0)?.strHomeLineupGoalkeeper
            str_def_home.text = it?.get(0)?.strHomeLineupDefense
            str_mid_home.text = it?.get(0)?.strHomeLineupMidfield
            str_stt_home.text = it?.get(0)?.strHomeLineupForward
            str_sub_home.text = it?.get(0)?.strHomeLineupSubstitutes

            str_gk_away.text = it?.get(0)?.strAwayLineupGoalkeeper
            str_def_away.text = it?.get(0)?.strAwayLineupDefense
            str_mid_away.text = it?.get(0)?.strAwayLineupMidfield
            str_stt_away.text = it?.get(0)?.strAwayLineupForward
            str_sub_away.text = it?.get(0)?.strAwayLineupSubstitutes
            if (it?.get(0)?.intHomeScore == null) {
                score_home_dtl.text = "0"
            } else {
                score_home_dtl.text = it.get(0).intHomeScore
            }

            if (it?.get(0)?.intAwayScore == null) {
                score_away_dtl.text = "0"
            } else {
                score_away_dtl.text = it.get(0).intAwayScore
            }
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
            badge = Clubs(it?.get(0)?.teamId, it?.get(0)?.teamName, it?.get(0)?.strTeamBadge)
            val away = it?.get(0)?.strTeamBadge
            Glide.with(applicationContext)
                .load(away)
                .into(bdg_home)
        }
    }

    override fun onDataError() {

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        menuItem = menu
        setFav()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.add_to_favorite -> {
                if (isFav) removeFav() else addtoFav()
                isFav = !isFav
                setFav()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun listFav() {
        database.use {
            val result = select(FavoriteMatch.TABLE_FAVORITE)
                .whereArgs("(ID_EVENT = {id})", "id" to id)
            val favorite = result.parseList(classParser<FavoriteMatch>())
            if (favorite.isNotEmpty()) isFav = true
        }
    }

    private fun addtoFav() {
        try {
            database.use {
                insert(
                    FavoriteMatch.TABLE_FAVORITE,
                    FavoriteMatch.ID_EVENT to match.idEvent,
                    FavoriteMatch.DATE_MATCH to match.dateEvent,
                    FavoriteMatch.TEAM_HOME_NAME to match.strHomeTeam,
                    FavoriteMatch.TEAM_HOME_BADGE to badge.strTeamBadge,
                    FavoriteMatch.HOME_SCORE to match.intHomeScore,
                    FavoriteMatch.HOME_GK to match.strHomeLineupGoalkeeper,
                    FavoriteMatch.HOME_DEF to match.strHomeLineupDefense,
                    FavoriteMatch.HOME_MID to match.strHomeLineupMidfield,
                    FavoriteMatch.HOME_FWD to match.strHomeLineupForward,
                    FavoriteMatch.HOME_SUB to match.strHomeLineupSubstitutes,

                    FavoriteMatch.TEAM_AWAY_NAME to match.strAwayTeam,
                    FavoriteMatch.TEAM_AWAY_BADGE to badge.strTeamBadge,
                    FavoriteMatch.AWAY_SCORE to match.intAwayScore,
                    FavoriteMatch.AWAY_GK to match.strAwayLineupGoalkeeper,
                    FavoriteMatch.AWAY_DEF to match.strAwayLineupDefense,
                    FavoriteMatch.AWAY_MID to match.strAwayLineupMidfield,
                    FavoriteMatch.AWAY_FWD to match.strAwayLineupForward,
                    FavoriteMatch.AWAY_SUB to match.strAwayLineupSubstitutes
                )

            }
            Toast.makeText(this, "Add to fav", Toast.LENGTH_SHORT).show()
        } catch (e: SQLiteConstraintException) {

        }
    }

    private fun removeFav() {
        try {
            database.use {
                delete(FavoriteMatch.TABLE_FAVORITE, "(ID_EVENT = {id})", "id" to id)
            }
            Toast.makeText(this, "Delete from fav", Toast.LENGTH_SHORT).show()
        } catch (e: SQLiteConstraintException) {

        }
    }

    private fun setFav() {
        if (isFav)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, ic_added_fav)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, ic_add_to_fav)
    }
}
