package com.szareckii.movieschart.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.szareckii.movieschart.R
import com.szareckii.movieschart.mvp.presenter.list.IRepositoryListPresenter
import com.szareckii.movieschart.mvp.view.listUsers.RepositoryItemView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_repository.*

class RepositoryRvAdapter(
    val presenter: IRepositoryListPresenter
): RecyclerView.Adapter<RepositoryRvAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        holder.containerView.setOnClickListener{ presenter.itemClickListener?.invoke(holder)}
        presenter.bindView(holder)
    }

    override fun getItemCount() =  presenter.getCount()

    inner class ViewHolder(override val containerView: View)
        : RecyclerView.ViewHolder(containerView), RepositoryItemView, LayoutContainer{

        override var pos = -1

        override fun setName(text: String) {
            tv_repository.text = text
        }

    }

}