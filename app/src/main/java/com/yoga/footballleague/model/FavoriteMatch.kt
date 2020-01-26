package com.yoga.footballleague.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FavoriteMatch(
    val id: Long?,
    val idEvent: String?,
    val dateMatch: String?,

    val teamHomeName: String?,
    val homeBadge: String?,
    val scoreHome: String?,
    val GkHome: String?,
    val defHome: String?,
    val midHome: String?,
    val forHome: String?,
    val subHome: String?,

    val teamAwayName: String?,
    val awayBadge: String?,
    val scoreAway: String?,
    val GkAway: String?,
    val defAway: String?,
    val midAway: String?,
    val forAway: String?,
    val subAway: String?
) : Parcelable {
    companion object {
        const val TABLE_FAVORITE: String = "Favorite_Match"
        const val ID: String = "ID_"
        const val ID_EVENT: String = "ID_EVENT"
        const val DATE_MATCH: String = "DATE_MATCH"

        const val TEAM_HOME_NAME: String = "TEAM_HOME_NAME"
        const val TEAM_HOME_BADGE: String = "TEAM_HOME_BADGE"
        const val HOME_SCORE: String = "HOME_SCORE"
        const val HOME_GK: String = "HOME_GK"
        const val HOME_DEF: String = "HOME_DEF"
        const val HOME_MID: String = "HOME_MID"
        const val HOME_FWD: String = "HOMW_FWD"
        const val HOME_SUB: String = "HOME_SUB"

        const val TEAM_AWAY_NAME: String = "AWAY_NAME"
        const val TEAM_AWAY_BADGE: String = "AWAY_BADGE"
        const val AWAY_SCORE: String = "AWAY_SCORE"
        const val AWAY_GK: String = "AWAY_GK"
        const val AWAY_DEF: String = "AWAY_DEF"
        const val AWAY_MID: String = "AWAY_MID"
        const val AWAY_FWD: String = "AWAY_FWD"
        const val AWAY_SUB: String = "AWAY_SUB"
    }
}