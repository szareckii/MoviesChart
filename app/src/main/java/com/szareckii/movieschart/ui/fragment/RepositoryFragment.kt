package com.szareckii.movieschart.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import com.szareckii.movieschart.databinding.FragmentRepositoryBinding
import com.szareckii.movieschart.mvp.model.entity.Movies
import com.szareckii.movieschart.mvp.model.entity.Results
import com.szareckii.movieschart.mvp.presenter.RepositoryPresenter
import com.szareckii.movieschart.mvp.view.RepositoryView
import com.szareckii.movieschart.ui.App
import com.szareckii.movieschart.ui.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class RepositoryFragment : MvpAppCompatFragment(), RepositoryView, BackButtonListener {

    companion object {
        private const val REPOSITORY_ARG = "repository"
        private const val USER_ARG = "user"
        fun newInstance(user: Movies, repository: Results) = RepositoryFragment().apply {
            arguments = Bundle().apply {
                putParcelable(USER_ARG, user)
                putParcelable(REPOSITORY_ARG, repository)
            }
        }
    }

    val presenter: RepositoryPresenter by moxyPresenter {

        val movie = arguments?.get(USER_ARG) as Results
        val repository = arguments?.getParcelable<Results>(REPOSITORY_ARG) as Results

        RepositoryPresenter(movie, repository).apply {
            App.component.inject(this)
        }
    }

    private var _binding: FragmentRepositoryBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): LinearLayout? {
        _binding = FragmentRepositoryBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun setLogin(text: String) {
        _binding?.loginUser?.text = text
    }

    override fun setTitle(text: String) {
        _binding?.nameRepository?.text = text
    }

    override fun setForksCount(text: String) {
        _binding?.numberOfForks?.text = text
    }

    override fun backPressed() = presenter.backClick()
}