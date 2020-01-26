package com.yoga.footballleague.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.yoga.footballleague.model.FavoriteMatch
import org.jetbrains.anko.db.*

class DbOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "db.FavoriteMatch", null, 1) {
    companion object {
        private var instance: DbOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): DbOpenHelper {
            if (instance == null) {
                instance = DbOpenHelper(ctx.applicationContext)
            }
            return instance as DbOpenHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(
            FavoriteMatch.TABLE_FAVORITE, true,
            FavoriteMatch.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            FavoriteMatch.ID_EVENT to TEXT + UNIQUE,
            FavoriteMatch.DATE_MATCH to TEXT,
            FavoriteMatch.TEAM_HOME_NAME to TEXT,
            FavoriteMatch.TEAM_HOME_BADGE to TEXT,
            FavoriteMatch.HOME_SCORE to TEXT,
            FavoriteMatch.HOME_GK to TEXT,
            FavoriteMatch.HOME_DEF to TEXT,
            FavoriteMatch.HOME_MID to TEXT,
            FavoriteMatch.HOME_FWD to TEXT,
            FavoriteMatch.HOME_SUB to TEXT,

            FavoriteMatch.TEAM_AWAY_NAME to TEXT,
            FavoriteMatch.TEAM_AWAY_BADGE to TEXT,
            FavoriteMatch.AWAY_SCORE to TEXT,
            FavoriteMatch.AWAY_GK to TEXT,
            FavoriteMatch.AWAY_DEF to TEXT,
            FavoriteMatch.AWAY_MID to TEXT,
            FavoriteMatch.AWAY_FWD to TEXT,
            FavoriteMatch.AWAY_SUB to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.dropTable(FavoriteMatch.TABLE_FAVORITE, true)
    }

}

val Context.database: DbOpenHelper
    get() = DbOpenHelper.getInstance(applicationContext)