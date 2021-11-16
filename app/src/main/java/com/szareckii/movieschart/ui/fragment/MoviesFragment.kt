package com.szareckii.movieschart.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.szareckii.movieschart.databinding.FragmentMoviesBinding
import com.szareckii.movieschart.mvp.model.image.IImageLoader
import com.szareckii.movieschart.mvp.presenter.MoviesPresenter
import com.szareckii.movieschart.mvp.view.MoviesView
import com.szareckii.movieschart.ui.App
import com.szareckii.movieschart.ui.BackButtonListener
import com.szareckii.movieschart.ui.adapter.MoviesRvAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MoviesFragment : MvpAppCompatFragment(), MoviesView, BackButtonListener {

    private var _binding: FragmentMoviesBinding? = null
    private var adapter: MoviesRvAdapter? = null

    @Inject lateinit var imageLoader: IImageLoader<ImageView>

    val presenter by moxyPresenter {
        MoviesPresenter().apply {
            App.component.inject(this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): RelativeLayout? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun init() {
        _binding?.rvMovies?.layoutManager =  GridLayoutManager(requireContext(), 2)
        adapter = MoviesRvAdapter(presenter.movieListPresenter)


        adapter = MoviesRvAdapter(presenter.movieListPresenter).apply {
            App.component.inject(this)
        }

        _binding?.rvMovies?.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun updateMoviesList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backClick()

    companion object {
        fun newInstance() = MoviesFragment()
    }
}
