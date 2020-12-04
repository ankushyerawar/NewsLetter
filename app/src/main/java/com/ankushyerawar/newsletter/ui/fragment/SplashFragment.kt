package com.ankushyerawar.newsletter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.ankushyerawar.newsletter.R
import com.ankushyerawar.newsletter.data.model.Splash
import com.ankushyerawar.newsletter.ui.viewmodel.SplashViewModel
import kotlinx.android.synthetic.main.fragment_splash.*

class SplashFragment : Fragment() {

    private val mViewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_splash, container, false)
        mViewModel.splashList = createSplashList()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //If the User is using this app for the second time don't show him splash screen
        if (mViewModel.showSplashFragment) {
            Navigation.findNavController(view)
                .navigate(SplashFragmentDirections.actionNavigationSplashToNavigationLaunch())
        }

        setUpViews(view)
    }

    private fun setUpViews(view: View) {
        view_flipper.inAnimation =
            AnimationUtils.loadAnimation(activity, R.anim.slide_in_right)
        view_flipper.outAnimation =
            AnimationUtils.loadAnimation(activity, R.anim.slide_out_left)

        var listIndex = mViewModel.showNext

        fab_next.setOnClickListener {

            if (listIndex < mViewModel.splashList!!.size - 1) {
                view_flipper.showNext()
                listIndex += 1
                lottie_splash.setAnimation(mViewModel.splashList!![listIndex].resId)
                lottie_splash.playAnimation()
                txt_header.text = mViewModel.splashList!![listIndex].titleHeader
                txt_desc.text = mViewModel.splashList!![listIndex].titleDesc

            } else {
                Navigation.findNavController(view)
                    .navigate(SplashFragmentDirections.actionNavigationSplashToNavigationLaunch())
            }
        }
    }

    private fun createSplashList(): List<Splash> {
        return listOf(
            Splash(
                R.raw.splash_one,
                resources.getString(R.string.title_header_one),
                resources.getString(R.string.title_desc_one)
            ),
            Splash(
                R.raw.splash_two,
                resources.getString(R.string.title_header_two),
                resources.getString(R.string.title_desc_two)
            ),
            Splash(
                R.raw.splash_three,
                resources.getString(R.string.title_header_three),
                resources.getString(R.string.title_desc_three)
            )
        )
    }


}
