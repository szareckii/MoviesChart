package com.szareckii.movieschart.mvp.presenter

import com.szareckii.movieschart.mvp.model.entity.Results
import com.szareckii.movieschart.mvp.view.MovieView
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MoviePresenter(private val movie: Results): MvpPresenter<MovieView>() {

    @Inject lateinit var router: Router
    @Inject lateinit var uiScheduler: Scheduler

    private val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        movie.overview?.let { viewState.setOverview(it) }

        movie.backdrop_path?.let { viewState.setBackdropPoster(it) }
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}