package com.ankushyerawar.newsletter.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.ankushyerawar.newsletter.R
import com.ankushyerawar.newsletter.ui.viewmodel.SplashViewModel
import kotlinx.android.synthetic.main.fragment_launch.*

class LaunchFragment : Fragment(R.layout.fragment_launch) {

    private val mViewModel: SplashViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //If the User is using this app for the first time don't show him launch screen
        if (!mViewModel.showSplashFragment) {
            Navigation.findNavController(view)
                .navigate(LaunchFragmentDirections.actionNavigationLaunchToNavigationHeadline())
        }

        //If this is the first time a User is using the app show him splash screen
        mViewModel.showSplashFragment = true

        //Animate TextView
        title_label.setCharacterDelay(CHAR_DELAY)
        title_label.animateText(resources.getString(R.string.app_name))

        val handler = Handler()
        handler.postDelayed({
            Navigation.findNavController(view)
                .navigate(LaunchFragmentDirections.actionNavigationLaunchToNavigationHeadline())
        }, NAV_DELAY)

    }

    companion object{
        const val CHAR_DELAY: Long = 150
        const val NAV_DELAY: Long = 2500
    }

}
