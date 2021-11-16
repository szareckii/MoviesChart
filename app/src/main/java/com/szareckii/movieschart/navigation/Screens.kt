package com.szareckii.movieschart.navigation

import com.szareckii.movieschart.mvp.model.entity.Results
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
}