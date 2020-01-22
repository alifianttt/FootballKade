package com.yoga.footballleague.league

import com.yoga.footballleague.model.LeagueList
import com.yoga.footballleague.repodata.RepoCallback

interface LeagueInterface: RepoCallback<LeagueList> {
    fun showProgressBar()
    fun hideProgressBar()
}