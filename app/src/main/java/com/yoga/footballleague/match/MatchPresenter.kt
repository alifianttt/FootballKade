package com.yoga.footballleague.match

import com.yoga.footballleague.model.EventList
import com.yoga.footballleague.repodata.RepoCallback
import com.yoga.footballleague.repodata.Repository
import com.yoga.footballleague.restapi.RepoApi

class MatchPresenter(private val view:MatchIntf, private val repo:Repository) {
    fun getNextMatch(id: String){
        repo.getNextMatch(id, object : RepoCallback<EventList>{
            override fun DataLoad(data: EventList?) {

            }

            override fun onDataError() {
            }
        })
    }

    fun getPrevMatch(id: String){
        repo.getPevtMatch(id, object : RepoCallback<EventList>{
            override fun DataLoad(data: EventList?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataError() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

    fun getEvents(e: String){
        repo.getEvents(e, object : RepoCallback<EventList>{
            override fun DataLoad(data: EventList?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataError() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}