package com.yoga.footballleague.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueData(val leagueName: String, val img:Int, val idLeague: String):Parcelable {
    override fun toString(): String = leagueName

}

