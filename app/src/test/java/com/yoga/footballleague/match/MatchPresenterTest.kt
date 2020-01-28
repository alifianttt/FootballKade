package com.yoga.footballleague.match

import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.verify
import com.yoga.footballleague.model.EventList
import com.yoga.footballleague.repodata.RepoCallback
import com.yoga.footballleague.repodata.Repository
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MatchPresenterTest {

    @Mock
    private lateinit var view: MatchIntf

    @Mock
    private lateinit var repo:Repository

    @Mock
    private lateinit var eventList: EventList

    @Mock
    private lateinit var presenter: MatchPresenter

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        presenter = MatchPresenter(view, repo)

    }

    @Test
    fun getNextMatch() {
        val id = "4326"
        presenter.getNextMatch(id)

        argumentCaptor<RepoCallback<EventList>>().apply {
            verify(repo).getNextMatch(eq(id), capture())
            firstValue.DataLoad(eventList)
        }
        Mockito.verify(view).DataLoad(eventList)
    }

    @Test
    fun getPrevMatch() {
        val id = "4326"
        presenter.getPrevMatch(id)

        argumentCaptor<RepoCallback<EventList>>().apply {
            verify(repo).getPevtMatch(eq(id), capture())
            firstValue.DataLoad(eventList)
        }

        Mockito.verify(view).DataLoad(eventList)
    }

    @Test
    fun getEvents() {
        val e = "Liverpool"

        presenter.getEvents(e)

        argumentCaptor<RepoCallback<EventList>>().apply {
            verify(repo).getEvents(eq(e), capture())
            firstValue.DataLoad(eventList)
        }

        Mockito.verify(view).DataLoad(eventList)
    }
}