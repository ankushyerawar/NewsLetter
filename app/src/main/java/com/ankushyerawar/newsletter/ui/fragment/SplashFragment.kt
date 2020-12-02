package com.ankushyerawar.newsletter.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.ViewFlipper
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.airbnb.lottie.LottieAnimationView
import com.ankushyerawar.newsletter.R
import com.ankushyerawar.newsletter.data.model.Splash
import com.ankushyerawar.newsletter.ui.viewmodel.SplashViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_splash.*

class SplashFragment : Fragment() {

    private val mViewModel: SplashViewModel by viewModels()

    private lateinit var mViewFlipper: ViewFlipper
    private lateinit var mLottieView: LottieAnimationView
    private lateinit var mTxtHeader: TextView
    private lateinit var mTxtDesc: TextView

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
//        if (mViewModel.showSplashFragment) {
//            Navigation.findNavController(view).navigate(SplashFragmentDirections.actionNavigationSplashToNavigationLaunch())
//        }

        setUpViews(view)
    }

    private fun setUpViews(view: View){
        mViewFlipper = view.findViewById(R.id.view_flipper)
        mLottieView = view.findViewById(R.id.lottie_splash)
        mTxtHeader = view.findViewById(R.id.txt_header)
        mTxtDesc = view.findViewById(R.id.txt_desc)

        val list = listOf(Splash(R.raw.splash_two,resources.getString(R.string.title_header_two),resources.getString(R.string.title_desc_two)),
            Splash(R.raw.splash_three,resources.getString(R.string.title_header_three),resources.getString(R.string.title_desc_three)))

        mViewFlipper.inAnimation = AnimationUtils.loadAnimation(activity,R.anim.slide_in_right)
        mViewFlipper.outAnimation = AnimationUtils.loadAnimation(activity,R.anim.slide_out_left)

        var index: Int = 0

        val fabButton: FloatingActionButton = view.findViewById(R.id.fab_next)
        fabButton.setOnClickListener {

            if (index < 2) {
                mViewFlipper.showNext()

                mLottieView.setAnimation(list[index].resId)
                mLottieView.playAnimation()

                mTxtHeader.text = list[index].titleHeader
                mTxtDesc.text = list[index].titleDesc

                index++
            } else {
                Navigation.findNavController(view).navigate(SplashFragmentDirections.actionNavigationSplashToNavigationLaunch())
            }

        }
    }




}
