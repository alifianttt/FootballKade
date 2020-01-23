package com.yoga.footballleague.model

import com.google.gson.annotations.SerializedName

class ClubResponse {
    @field:SerializedName("teams")
    val teams: List<Clubs>? = null
}