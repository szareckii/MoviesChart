package com.szareckii.movieschart.mvp.model.image

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}