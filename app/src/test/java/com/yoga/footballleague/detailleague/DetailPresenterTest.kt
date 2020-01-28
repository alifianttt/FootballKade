package com.yoga.footballleague.detailleague

import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.verify
import com.yoga.footballleague.model.LeagueList
import com.yoga.footballleague.repodata.RepoCallback
import com.yoga.footballleague.repodata.Repository
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailPresenterTest {

    @Mock
    private lateinit var view: DetailView

    @Mock
    private lateinit var  repo: Repository

    @Mock
    private lateinit var leagues : LeagueList

    @Mock
    private lateinit var detailPresenter: DetailPresenter

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)

        detailPresenter = DetailPresenter(view, repo)
    }

    //Tes untuk mendapatkan detail liga
    @Test
    fun getDetail() {
        val id = "4328"
        detailPresenter.getDetail(id)

        argumentCaptor<RepoCallback<LeagueList>>().apply {
            verify(repo).getLeagues(eq(id), capture())
            firstValue.DataLoad(leagues)
        }

        Mockito.verify(view).DataLoad(leagues)
    }

    @Test
    fun getDetailErr(){
        val id = ""
        detailPresenter.getDetail(id)

        argumentCaptor<RepoCallback<LeagueList>>().apply {
            verify(repo).getLeagues(eq(id), capture())
            firstValue.onDataError()
        }

        Mockito.verify(view).onDataError()
    }

}