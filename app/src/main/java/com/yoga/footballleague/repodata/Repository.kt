package com.yoga.footballleague.repodata

import com.yoga.footballleague.model.ClubResponse
import com.yoga.footballleague.model.EventList
import com.yoga.footballleague.model.LeagueList
import com.yoga.footballleague.restapi.BaseRest
import com.yoga.footballleague.restapi.RepoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    fun getLeagues(id: String, callback: RepoCallback<LeagueList>) {
        BaseRest
            .createService(RepoApi::class.java)
            .getLeagues(id)
            .enqueue(object : Callback<LeagueList> {
                override fun onFailure(call: Call<LeagueList>, t: Throwable) {
                    callback.onDataError()
                }
                override fun onResponse(
                    call: Call<LeagueList>,
                    response: Response<LeagueList>){

                    response.let {
                        if(it.isSuccessful){
                            callback.DataLoad(it.body())
                        } else {
                            callback.onDataError()
                        }
                    }

                }
            })
    }

    fun getNextMatch(id: String, callback: RepoCallback<EventList>){
        BaseRest
            .createService(RepoApi::class.java)
            .getNextMatch(id)
            .enqueue(object : Callback<EventList>{
                override fun onFailure(call: Call<EventList>, t: Throwable) {
                    callback.onDataError()
                }

                override fun onResponse(call: Call<EventList>, response: Response<EventList>) {
                       response.let {
                           if (it.isSuccessful){
                               callback.DataLoad(it.body())
                           } else {
                               callback.onDataError()
                           }
                       }
                }

            })
    }


    
    fun getPevtMatch(id: String, callback: RepoCallback<EventList>){
        BaseRest
            .createService(RepoApi::class.java)
            .getPastMatch(id)
            .enqueue(object : Callback<EventList>{
                override fun onFailure(call: Call<EventList>, t: Throwable) {
                    callback.onDataError()
                }

                override fun onResponse(call: Call<EventList>, response: Response<EventList>) {
                    response.let {
                        if (it.isSuccessful){
                            callback.DataLoad(it.body())
                        } else {
                            callback.onDataError()
                        }
                    }
                }

            })
    }

    fun getEvents(id: String, callback: RepoCallback<EventList>){
        BaseRest
            .createService(RepoApi::class.java)
            .getEvents(id)
            .enqueue(object : Callback<EventList>{
                override fun onFailure(call: Call<EventList>, t: Throwable) {
                    callback.onDataError()
                }

                override fun onResponse(call: Call<EventList>, response: Response<EventList>) {
                    response.let {
                        if (it.isSuccessful){
                            callback.DataLoad(it.body())
                        } else {
                            callback.onDataError()
                        }
                    }
                }

            })
    }

    fun getEvent(id: String, callback: RepoCallback<EventList>){
        BaseRest
            .createService(RepoApi::class.java)
            .getEvent(id)
            .enqueue(object : Callback<EventList>{
                override fun onFailure(call: Call<EventList>, t: Throwable) {
                    callback.onDataError()
                }

                override fun onResponse(call: Call<EventList>, response: Response<EventList>) {
                    response.let {
                        if (it.isSuccessful){
                            callback.DataLoad(it.body())
                        } else {
                            callback.onDataError()
                        }
                    }
                }

            })
    }

    fun getTeams(id: String, callback: RepoCallback<ClubResponse>){
        BaseRest
            .createService(RepoApi::class.java)
            .getTeams(id)
            .enqueue(object : Callback<ClubResponse>{
                override fun onFailure(call: Call<ClubResponse>, t: Throwable) {
                    callback.onDataError()
                }

                override fun onResponse(
                    call: Call<ClubResponse>,
                    response: Response<ClubResponse>
                ) {
                    response.let {
                        if (it.isSuccessful){
                            callback.DataLoad(it.body())
                        } else{
                            callback.onDataError()
                        }
                    }
                }
            })
    }

    fun getTeamName(t: String, callback: RepoCallback<ClubResponse>){
        BaseRest
            .createService(RepoApi::class.java)
            .getTeamName(t)
            .enqueue(object : Callback<ClubResponse> {
                override fun onFailure(call: Call<ClubResponse>, t: Throwable) {
                    callback.onDataError()
                }

                override fun onResponse(
                    call: Call<ClubResponse>,
                    response: Response<ClubResponse>
                ) {
                    response.let {
                        if (it.isSuccessful) {
                            callback.DataLoad(it.body())
                        } else {
                            callback.onDataError()
                        }
                    }
                }
            })
    }
}