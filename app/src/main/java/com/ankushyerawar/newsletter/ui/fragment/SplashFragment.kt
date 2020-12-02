package com.ankushyerawar.newsletter.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.ankushyerawar.newsletter.R
import com.ankushyerawar.newsletter.ui.viewmodel.SplashViewModel
import kotlinx.android.synthetic.main.fragment_splash.*

class SplashFragment : Fragment() {

    private val mViewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //If the User is using this app for the second time don't show him splash screen
        if (mViewModel.showSplashFragment) {
            Navigation.findNavController(view).navigate(SplashFragmentDirections.actionNavigationSplashToNavigationLaunch())
        }

        btn_next.setOnClickListener {
            Navigation.findNavController(view).navigate(SplashFragmentDirections.actionNavigationSplashToNavigationLaunch())
        }
    }




}
