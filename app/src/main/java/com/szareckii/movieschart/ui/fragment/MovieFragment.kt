package com.szareckii.movieschart.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.szareckii.movieschart.databinding.FragmentMovieBinding
import com.szareckii.movieschart.mvp.model.entity.Results
import com.szareckii.movieschart.mvp.model.image.IImageLoader
import com.szareckii.movieschart.mvp.presenter.MoviePresenter
import com.szareckii.movieschart.mvp.view.MovieView
import com.szareckii.movieschart.ui.App
import com.szareckii.movieschart.ui.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MovieFragment : MvpAppCompatFragment(), MovieView, BackButtonListener {

    companion object {
        private const val USER_ARG = "movie"
        fun newInstance(movie: Results) = MovieFragment().apply {
            arguments = Bundle().apply {
                putParcelable(USER_ARG, movie)
            }
        }
    }

    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>

    val presenter: MoviePresenter by moxyPresenter {

        val movie = arguments?.getParcelable<Results>(USER_ARG) as Results

        MoviePresenter(movie).apply {
            App.component.inject(this)
        }
    }

//    private var adapter: RepositoryRvAdapter? = null

    private var _binding: FragmentMovieBinding? = null

    override fun onCreateView
                (inflater: LayoutInflater,
                 container: ViewGroup?,
                 savedInstanceState: Bundle?
    ): ConstraintLayout? {
        App.component.inject(this)
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun setOverview(text: String) {
        _binding?.overviewTextview?.text = text

    }

    override fun setBackdropPoster(url: String) {
        _binding?.detailsImagePoster?.let { imageLoader.loadInto(url, it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun backPressed() = presenter.backClick()
}