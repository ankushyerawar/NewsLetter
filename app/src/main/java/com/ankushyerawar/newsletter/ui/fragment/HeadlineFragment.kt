package com.ankushyerawar.newsletter.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ankushyerawar.newsletter.R
import com.ankushyerawar.newsletter.ui.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_headline.*

class HeadlineFragment : Fragment() {

    //SplashViewModel
    private val mViewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_headline, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (mViewModel.isInternetAvailable) {
            Log.e("onActivityCreated","True" )
        } else {
            Log.e("onActivityCreated","False")
        }
    }

    override fun onResume() {
        super.onResume()
        shimmerFrameLayout.startShimmerAnimation()
    }

}