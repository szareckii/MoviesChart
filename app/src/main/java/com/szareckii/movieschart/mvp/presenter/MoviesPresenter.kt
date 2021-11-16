package com.szareckii.movieschart.mvp.presenter

import com.szareckii.movieschart.mvp.model.entity.Results
import com.szareckii.movieschart.mvp.model.repo.IMoviesRepo
import com.szareckii.movieschart.mvp.presenter.list.IMovieListPresenter
import com.szareckii.movieschart.mvp.view.MoviesView
import com.szareckii.movieschart.mvp.view.listUsers.MovieItemView
import com.szareckii.movieschart.navigation.Screens
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MoviesPresenter(): MvpPresenter<MoviesView>() {

    @Inject lateinit var moviesRepo: IMoviesRepo
    @Inject lateinit var router: Router
    @Inject lateinit var uiScheduler: Scheduler

    class MovieListPresenter: IMovieListPresenter{
        override var itemClickListener: ((MovieItemView) -> Unit)? = null

        val movies = mutableListOf<Results>()

        override fun bindView(view: MovieItemView) {
            val movie = movies[view.pos]
            movie.title?.let { view.setTitle(it) }
//            movie.release_date?.let { dateEnglish ->
//                formatDate(dateEnglish)?.let { dateRussian ->
//                    view.setReleaseDate(dateRussian) }
//            }

            movie.release_date?.let { view.setReleaseDate(it) }
            movie.poster_path?.let { view.loadImage(it) }
        }

        override fun getCount() = movies.size

//        private fun formatDate(dateString: String): String? {
//            try {
//                val formatter = SimpleDateFormat("dd-MMMM-yyyy", Locale.getDefault())
//                val mDate = formatter.parse(dateString)
//                return mDate?.toString()
//            } catch (e: ParseException) {
//            }
//            return ""
//        }
    }

    val movieListPresenter = MovieListPresenter()
    private val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        movieListPresenter.itemClickListener = { itemView ->
//            router.navigateTo(Screens.DetailsOldScreen(movieListPresenter.movies[itemView.pos]))
            router.navigateTo(Screens.DetailsScreen(movieListPresenter.movies[itemView.pos]))
        }
    }

    private fun loadData() {
         moviesRepo.getMovies("ru")
            .observeOn(uiScheduler)
            .subscribe({ repos ->
                movieListPresenter.movies.clear()
                movieListPresenter.movies.addAll(repos)
                viewState.updateMoviesList()
            }, {
                println("Error: ${it.message}")

            }).addTo(compositeDisposable)
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