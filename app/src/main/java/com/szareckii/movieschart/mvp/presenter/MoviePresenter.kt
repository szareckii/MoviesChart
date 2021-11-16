package com.szareckii.movieschart.mvp.presenter

import com.szareckii.movieschart.mvp.model.entity.Results
import com.szareckii.movieschart.mvp.model.repo.IGithubRepositoriesRepo
import com.szareckii.movieschart.mvp.presenter.list.IRepositoryListPresenter
import com.szareckii.movieschart.mvp.view.MovieView
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MoviePresenter(private val movie: Results): MvpPresenter<MovieView>() {

    @Inject lateinit var repositoriesRepo: IGithubRepositoriesRepo
    @Inject lateinit var router: Router
    @Inject lateinit var uiScheduler: Scheduler

/*
    class RepositoryListPresenter: IRepositoryListPresenter {
        override var itemClickListener: ((RepositoryItemView) -> Unit)? = null

        private val repositories = mutableListOf<Results>()

        override fun bindView(view: RepositoryItemView) {
            val repository = repositories[view.pos]
//            repository.name?.let { view.setName(it) }
        }

        override fun getCount() = repositories.size
    }
*/

//    val repositoryListPresenter = RepositoryListPresenter()

    private val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
//        viewState.init()
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