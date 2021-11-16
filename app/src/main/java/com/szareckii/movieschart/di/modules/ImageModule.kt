package com.szareckii.movieschart.di.modules

import android.widget.ImageView
import com.szareckii.movieschart.mvp.model.image.IImageLoader
import com.szareckii.movieschart.ui.image.GlideImageLoader
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class ImageModule {

    @Named("imageBaseUrl")
    @Provides
    fun baseUrl() = "https://image.tmdb.org/t/p/w500/"

    @Singleton
    @Provides
    fun imageLoader(@Named("imageBaseUrl") imageBaseUrl: String): IImageLoader<ImageView> =
        GlideImageLoader(imageBaseUrl)
}