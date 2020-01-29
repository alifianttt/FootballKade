package com.yoga.footballleague.detailteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.yoga.footballleague.R
import com.yoga.footballleague.main.MainPresenter
import com.yoga.footballleague.main.MainView
import com.yoga.footballleague.model.ClubResponse
import com.yoga.footballleague.repodata.Repository
import kotlinx.android.synthetic.main.activity_detail_team.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class DetailTeam : AppCompatActivity(), MainView {

    private var menuItem : Menu? = null
    private lateinit var nameTeam : String
    private lateinit var idTeam : String
    private lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)
        nameTeam = intent.getStringExtra("nameTeam")
        idTeam = intent.getStringExtra("idTeam")
        presenter = MainPresenter(this, Repository())
        presenter.getTeamsDetail(nameTeam)
    }

    override fun DataLoad(data: ClubResponse?) {
        data?.teams.let {
            tv_detail_team.text = it?.get(0)?.strDescriptionEN
            tv_name_team.text = it?.get(0)?.teamName
            val img = it?.get(0)?.strTeamBadge
            Glide.with(applicationContext)
                .load(img)
                .into(img_detail_team)
        }
    }

    override fun onDataError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        menuItem = menu

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                finish()
                true
            }
            R.id.add_to_favorite ->{

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
