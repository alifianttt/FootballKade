package com.yoga.footballleague.matchdetail

import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.verify
import com.yoga.footballleague.match.MatchPresenter
import com.yoga.footballleague.model.ClubResponse
import com.yoga.footballleague.model.EventList
import com.yoga.footballleague.repodata.RepoCallback
import com.yoga.footballleague.repodata.Repository
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MatchDetailPresTest {

    @Mock
    private lateinit var view: MatchDetailView

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var eventList: EventList

    @Mock
    private lateinit var badge : ClubResponse

    @Mock
    private lateinit var presenter: MatchDetailPres

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        presenter = MatchDetailPres(view, repository)
    }
    //Unit Test untuk mendapatkan detail match
    @Test
    fun getEventDetail() {
        val id = "673963"
        presenter.getEvent(id)

        argumentCaptor<RepoCallback<EventList>>().apply {
            verify(repository).getEvent(eq(id), capture())
            firstValue.DataLoad(eventList)
        }
        Mockito.verify(view).getEvent(eventList)
    }
    //Unit Test untuk mendapatkan detail team untuk diambil badgenya
    @Test
    fun getTeamHome() {
        val name = "Liverpool"

        presenter.getTeamHome(name)
        argumentCaptor<RepoCallback<ClubResponse>>().apply {
            verify(repository).getTeamName(eq(name), capture())
            firstValue.DataLoad(badge)
        }
        Mockito.verify(view).DataLoad(badge)
    }

    //Unit Test untuk mendapatkan detail team untuk diambil badgenya
    @Test
    fun getTeamAway() {
        val name = "Shrewsbury"

        presenter.getTeamAway(name)
        argumentCaptor<RepoCallback<ClubResponse>>().apply {
            verify(repository).getTeamName(eq(name), capture())
            firstValue.DataLoad(badge)
        }
        Mockito.verify(view).showBadge(badge)
    }
}