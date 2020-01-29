package com.yoga.footballleague.model

import com.google.gson.annotations.SerializedName

data class EventList(
    @SerializedName("events")
    val events: List<EventDetail>? = null,

    @SerializedName("event")
    val event: List<EventDetail>? = null,

    @SerializedName("table")
    val table: List<TableItem>? = null
)