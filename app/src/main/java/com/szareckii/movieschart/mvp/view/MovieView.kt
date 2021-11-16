package com.szareckii.movieschart.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface MovieView: MvpView {
    fun init()
    fun updateUserReposList()
    fun setOverview(text: String)
    fun setBackdropPoster(url: String)
}
