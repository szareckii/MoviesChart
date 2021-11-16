package com.szareckii.movieschart.mvp.presenter

import com.szareckii.movieschart.mvp.view.MainView
import com.szareckii.movieschart.navigation.Screens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter(): MvpPresenter<MainView>() {

    @Inject lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.MoviesScreen())
    }

    fun backClick() {
        router.exit()
    }

}