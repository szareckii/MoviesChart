package com.szareckii.movieschart.mvp.model.api

import com.szareckii.movieschart.mvp.model.entity.Movies
import com.szareckii.movieschart.mvp.model.entity.Results
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface IDataSource {

    @GET("discover/movie")
    fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Single<Movies>

    @GET
    fun getRepositories(@Url url: String): Single<List<Results>>

}