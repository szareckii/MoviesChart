package com.szareckii.movieschart.mvp.model.repo

import com.szareckii.movieschart.mvp.model.entity.Results
import io.reactivex.rxjava3.core.Single

interface IMoviesRepo {

    fun getMovies(language: String): Single<List<Results>>
}