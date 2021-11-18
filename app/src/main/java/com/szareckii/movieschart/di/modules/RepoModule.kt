package com.szareckii.movieschart.di.modules

import com.szareckii.movieschart.mvp.model.api.IDataSource
import com.szareckii.movieschart.mvp.model.repo.IMoviesRepo
import com.szareckii.movieschart.mvp.model.repo.retrofit.RetrofitMoviesRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun moviesRepo(api: IDataSource) : IMoviesRepo =
        RetrofitMoviesRepo(api)

}