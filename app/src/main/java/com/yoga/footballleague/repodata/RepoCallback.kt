package com.yoga.footballleague.repodata

interface RepoCallback<T> {
    fun DataLoad(data: T?)
    fun onDataError()
}