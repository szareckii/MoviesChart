package com.szareckii.movieschart.navigation

import com.szareckii.movieschart.mvp.model.entity.Movies
import com.szareckii.movieschart.mvp.model.entity.Results
import com.szareckii.movieschart.ui.fragment.RepositoryFragment
import com.szareckii.movieschart.ui.fragment.MovieFragment
import com.szareckii.movieschart.ui.fragment.MoviesFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class MoviesScreen(): SupportAppScreen() {
        override fun getFragment() = MoviesFragment.newInstance()
    }

    class DetailsScreen(private val movie: Results): SupportAppScreen() {
        override fun getFragment() = MovieFragment.newInstance(movie)
    }

//    class DetailsOldScreen(private val movie: Results, private val repository: Results): SupportAppScreen() {
//        override fun getFragment() = RepositoryFragment.newInstance(movie, repository)
//    }
}