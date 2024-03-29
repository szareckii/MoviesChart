package com.szareckii.movieschart.di.modules

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.szareckii.movieschart.mvp.model.api.IDataSource
import com.szareckii.movieschart.mvp.model.network.INetworkStatus
import com.szareckii.movieschart.ui.App
import com.szareckii.movieschart.ui.network.AndroidNetworkStatus
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

    @Named("baseUrl")
    @Provides
    fun baseUrl() = "https://api.themoviedb.org/3/"

    @Singleton
    @Provides
    fun api(@Named("baseUrl") baseUrl: String,  gson: Gson): IDataSource = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(IDataSource::class.java)

    @Singleton
    @Provides
    fun gson() = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .excludeFieldsWithoutExposeAnnotation()
            .create()

    @Singleton
    @Provides
    fun networkStatus(app: App) : INetworkStatus = AndroidNetworkStatus(app)

}