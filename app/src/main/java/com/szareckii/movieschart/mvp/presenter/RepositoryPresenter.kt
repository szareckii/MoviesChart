package com.szareckii.movieschart.mvp.presenter

import com.szareckii.movieschart.mvp.model.entity.Results
import com.szareckii.movieschart.mvp.model.entity.Movies
import com.szareckii.movieschart.mvp.view.RepositoryView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class RepositoryPresenter(val movie: Results, private val githubRepository: Results): MvpPresenter<RepositoryView>() {

    @Inject lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
//        viewState.setLogin(user.login ?: "")
//        viewState.setTitle(githubRepository.name ?: "")
//        viewState.setForksCount(githubRepository.forksCount ?: "")
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}