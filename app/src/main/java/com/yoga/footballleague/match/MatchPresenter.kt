package com.yoga.footballleague.match

import com.yoga.footballleague.model.EventList
import com.yoga.footballleague.repodata.RepoCallback
import com.yoga.footballleague.repodata.Repository
import com.yoga.footballleague.restapi.RepoApi

class MatchPresenter(private val view:MatchIntf, private val repo:Repository) {
    fun getNextMatch(id: String){
        repo.getNextMatch(id, object : RepoCallback<EventList>{
            override fun DataLoad(data: EventList?) {
                view.DataLoad(data)
            }

            override fun onDataError() {
                view.onDataError()
            }
        })
    }

    fun getPrevMatch(id: String){
        repo.getPevtMatch(id, object : RepoCallback<EventList>{
            override fun DataLoad(data: EventList?) {
                view.DataLoad(data)
            }

            override fun onDataError() {
                view.onDataError()
            }
        })
    }

    fun getEvents(e: String){
        repo.getEvents(e, object : RepoCallback<EventList>{
            override fun DataLoad(data: EventList?) {
                view.DataLoad(data)
            }

            override fun onDataError() {
                view.onDataError()
            }
        })
    }
}