package com.szareckii.movieschart.mvp.model.repo.retrofit

import com.szareckii.movieschart.mvp.model.api.IDataSource
import com.szareckii.movieschart.mvp.model.network.INetworkStatus
import com.szareckii.movieschart.mvp.model.repo.IGithubRepositoriesRepo

class RetrofitGithubRepositoriesRepo(
    private val api: IDataSource,
    private val networkStatus: INetworkStatus
): IGithubRepositoriesRepo {
//
//    override fun getRepositories(user: Results): Single<List<Results>> = networkStatus.isOnlineSingle().flatMap { isOnline ->
//        if (isOnline) {
//            user.id?.let { url ->
//                api.getRepositories(url).flatMap { repositories ->
//                    cacheRepositories.putUserRepos(user, repositories).andThen(Single.just(repositories))
//                }
//            } ?: Single.error<List<Results>>(RuntimeException("User has no repos url")).subscribeOn(Schedulers.io())
//
//        } else {
//            cacheRepositories.getUserRepos(user)
//        }
//    }.subscribeOn(Schedulers.io())

}
