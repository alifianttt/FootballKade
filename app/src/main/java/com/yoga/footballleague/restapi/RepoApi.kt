package com.yoga.footballleague.restapi

import com.yoga.footballleague.model.ClubResponse
import com.yoga.footballleague.model.EventList
import com.yoga.footballleague.model.LeagueList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RepoApi {
    @GET("lookupleague.php")
    fun getLeagues(@Query("id") id: String) : Call<LeagueList>

    @GET("eventsnextleague.php")
    fun getNextMatch(@Query("id") id: String) : Call<EventList>

    @GET("eventspastleague.php")
    fun getPastMatch(@Query("id") id : String) : Call<EventList>

    @GET("searchevents.php")
    fun getEvents(@Query("e") e: String) : Call<EventList>

    @GET("lookup_all_teams.php")
    fun getTeams(@Query("id") id: String) : Call<ClubResponse>


}