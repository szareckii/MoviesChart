package com.szareckii.movieschart.mvp.view.listUsers

interface MovieItemView: IItemView {
    fun setTitle(text: String)
    fun setReleaseDate(releaseDate: String)
    fun loadImage(url: String)
}