package com.yoga.footballleague.matchdetail

import com.yoga.footballleague.model.ClubResponse
import com.yoga.footballleague.model.Clubs
import com.yoga.footballleague.model.EventDetail
import com.yoga.footballleague.model.EventList
import com.yoga.footballleague.repodata.RepoCallback

interface MatchDetailView : RepoCallback<ClubResponse>{
    fun showBadge(data: ClubResponse?)
}