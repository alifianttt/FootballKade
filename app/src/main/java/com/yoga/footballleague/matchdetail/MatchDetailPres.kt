package com.yoga.footballleague.matchdetail

import com.yoga.footballleague.model.ClubResponse
import com.yoga.footballleague.repodata.RepoCallback
import com.yoga.footballleague.repodata.Repository

class MatchDetailPres(private val view: MatchDetailView, private val repo: Repository) {

    fun getTeamHome(l: String) {
        repo.getTeamName(l, object : RepoCallback<ClubResponse> {
            override fun DataLoad(data: ClubResponse?) {
                view.DataLoad(data)
            }

            override fun onDataError() {
                view.onDataError()
            }

        })
    }

    fun getTeamAway(l: String) {
        repo.getTeamName(l, object : RepoCallback<ClubResponse> {
            override fun DataLoad(data: ClubResponse?) {
                view.showBadge(data)
            }

            override fun onDataError() {

            }

        })
    }
}