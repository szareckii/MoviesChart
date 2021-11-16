package com.szareckii.movieschart.mvp.model.repo.retrofit

import com.szareckii.movieschart.BuildConfig.MOVIE_API_KEY
import com.szareckii.movieschart.mvp.model.api.IDataSource
import com.szareckii.movieschart.mvp.model.entity.Results
import com.szareckii.movieschart.mvp.model.repo.IMoviesRepo
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitMoviesRepo(private val api: IDataSource): IMoviesRepo {

    override fun getMovies(language: String): Single<List<Results>> =
        api.getMovies(MOVIE_API_KEY, language).flatMap { movies ->
            Single.just(movies.results)
        }.subscribeOn(Schedulers.io())
}
