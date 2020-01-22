package com.yoga.footballleague.model

import com.google.gson.annotations.SerializedName

data class LeagueList (
    @SerializedName("leagues")
    val leagues: List<LeagueItems>? = null
)