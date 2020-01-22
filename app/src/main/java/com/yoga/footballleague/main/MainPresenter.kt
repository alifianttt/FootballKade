package com.yoga.footballleague.main

import com.yoga.footballleague.model.ClubResponse
import com.yoga.footballleague.repodata.RepoCallback
import com.yoga.footballleague.repodata.Repository

class MainPresenter(private val view: MainView, private val repository: Repository) {
    fun getTeams(id : String){
        repository.getTeams(id, object : RepoCallback<ClubResponse>{
            override fun DataLoad(data: ClubResponse?) {
                view.DataLoad(data)
            }

            override fun onDataError() {
                view.onDataError()
            }
        })
    }
}