package com.szareckii.movieschart.ui.activity

import android.os.Bundle
import com.szareckii.movieschart.R
import com.szareckii.movieschart.mvp.presenter.MainPresenter
import com.szareckii.movieschart.mvp.view.MainView
import com.szareckii.movieschart.ui.App
import com.szareckii.movieschart.ui.BackButtonListener
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {

    @Inject lateinit var navigatorHolder: NavigatorHolder

    private val navigator = SupportAppNavigator(this, supportFragmentManager, R.id.container)

    val presenter by moxyPresenter {
        MainPresenter().apply {
            App.component.inject(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.component.inject(this)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
         supportFragmentManager.fragments.forEach{
             if(it is BackButtonListener && it.backPressed()){
                 return
             }
         }
        presenter.backClick()
    }
}