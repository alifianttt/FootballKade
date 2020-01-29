package com.yoga.footballleague.model

import com.google.gson.annotations.SerializedName

data class Clubs(
    @SerializedName("idTeam")
    var teamId: String? = null,

    @SerializedName("strTeam")
    var teamName: String? = null,

    @field:SerializedName("strTeamBadge")
    val strTeamBadge: String? = null,

    @field:SerializedName("strDescriptionEN")
    val strDescriptionEN: String? = null
)