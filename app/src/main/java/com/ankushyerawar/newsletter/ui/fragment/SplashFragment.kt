package com.ankushyerawar.newsletter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.ankushyerawar.newsletter.R
import com.ankushyerawar.newsletter.data.model.Splash
import com.ankushyerawar.newsletter.databinding.FragmentSplashBinding
import com.ankushyerawar.newsletter.ui.viewmodel.SplashViewModel

class SplashFragment : Fragment() {

    private val mViewModel: SplashViewModel by viewModels()

    private lateinit var mBinding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false)
        mBinding.viewModel = mViewModel
        mViewModel.splashList = createSplashList()
        mBinding.splash = mViewModel.splashList?.get(mViewModel.showNext)
        return mBinding.root
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
        mBinding.viewFlipper.inAnimation =
            AnimationUtils.loadAnimation(activity, R.anim.slide_in_right)
        mBinding.viewFlipper.outAnimation =
            AnimationUtils.loadAnimation(activity, R.anim.slide_out_left)

        mBinding.fabNext.setOnClickListener {

            if (mViewModel.showNext < mViewModel.splashList!!.size - 1) {
                mBinding.viewFlipper.showNext()

                mViewModel.showNext += 1

                mBinding.splash = mViewModel.splashList?.get(mViewModel.showNext)
                mBinding.lottieSplash.setAnimation(mBinding.splash!!.resId)
                mBinding.lottieSplash.playAnimation()

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
