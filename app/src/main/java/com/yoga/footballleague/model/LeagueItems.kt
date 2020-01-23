package com.yoga.footballleague.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueItems(
    @SerializedName("strLeague")
    val strLeague: String?,

    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String?,

    @SerializedName("strTrophy")
    val strTrophy: String?
) : Parcelable