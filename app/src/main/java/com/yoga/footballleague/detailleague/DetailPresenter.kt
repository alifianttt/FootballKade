package com.yoga.footballleague.detailleague

import com.yoga.footballleague.model.LeagueList
import com.yoga.footballleague.repodata.RepoCallback
import com.yoga.footballleague.repodata.Repository

class DetailPresenter(private val view: DetailView, private val repo: Repository) {
    fun getDetail(id: String) {
        repo.getLeagues(id, object : RepoCallback<LeagueList> {
            override fun DataLoad(data: LeagueList?) {
                view.DataLoad(data)
            }

            override fun onDataError() {
                view.onDataError()
            }
        })
    }
}