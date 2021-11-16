package com.szareckii.movieschart.di.modules

import com.szareckii.movieschart.mvp.model.api.IDataSource
import com.szareckii.movieschart.mvp.model.network.INetworkStatus
import com.szareckii.movieschart.mvp.model.repo.IGithubRepositoriesRepo
import com.szareckii.movieschart.mvp.model.repo.IMoviesRepo
import com.szareckii.movieschart.mvp.model.repo.retrofit.RetrofitMoviesRepo
import com.szareckii.movieschart.mvp.model.repo.retrofit.RetrofitGithubRepositoriesRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun moviesRepo(api: IDataSource) : IMoviesRepo =
        RetrofitMoviesRepo(api)

    @Singleton
    @Provides
    fun repositoriesRepo(api: IDataSource, networkStatus: INetworkStatus) : IGithubRepositoriesRepo =
        RetrofitGithubRepositoriesRepo(api, networkStatus)

}