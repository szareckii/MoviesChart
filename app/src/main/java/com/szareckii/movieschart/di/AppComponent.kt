package com.szareckii.movieschart.di

import com.szareckii.movieschart.di.modules.*
import com.szareckii.movieschart.mvp.presenter.MainPresenter
import com.szareckii.movieschart.mvp.presenter.MoviePresenter
import com.szareckii.movieschart.mvp.presenter.MoviesPresenter
import com.szareckii.movieschart.ui.activity.MainActivity
import com.szareckii.movieschart.ui.adapter.MoviesRvAdapter
import com.szareckii.movieschart.ui.fragment.MovieFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApiModule::class,
    AppModule::class,
    ImageModule::class,
    NavigationModule::class,
    RepoModule::class
])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(moviesPresenter: MoviesPresenter)
    fun inject(movieDetailsPresenter: MoviePresenter)
    fun inject(moviesRvAdapter: MoviesRvAdapter)
    fun inject(movieFragment: MovieFragment)
}