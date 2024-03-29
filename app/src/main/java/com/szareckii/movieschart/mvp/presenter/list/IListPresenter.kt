package com.szareckii.movieschart.mvp.presenter.list

import com.szareckii.movieschart.mvp.view.listUsers.IItemView

interface IListPresenter<V: IItemView> {
    var itemClickListener: ((V)-> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}