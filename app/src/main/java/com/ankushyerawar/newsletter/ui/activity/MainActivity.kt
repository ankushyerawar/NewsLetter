package com.ankushyerawar.newsletter.ui.activity

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationSet
import android.view.animation.OvershootInterpolator
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.ankushyerawar.newsletter.R
import com.ankushyerawar.newsletter.utils.BottomNavigationViewIndicator
import com.ankushyerawar.newsletter.utils.ListenableBottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var mNavView: ListenableBottomNavigationView
    private lateinit var mNavController: NavController

    private lateinit var mRootLayout: ConstraintLayout
    private lateinit var mIndicatorView: BottomNavigationViewIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mNavView = findViewById(R.id.nav_view)
        mRootLayout = findViewById(R.id.container)
        mIndicatorView = findViewById(R.id.indicator_view)
        mNavController = findNavController(R.id.nav_host_fragment)

        setUpNav()
        animateBottomView(mNavView)
    }

    override fun onBackPressed() {
        mIndicatorView.setSelectedIndex(0)
        super.onBackPressed()
    }

    //Navigation Set-Up
    private fun setUpNav() {
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications
            )
        )

        setupActionBarWithNavController(mNavController, appBarConfiguration)
        mNavView.setupWithNavController(mNavController)
    }

    //Animate Bottom Navigation View
    private fun animateBottomView(view: View) {
        view.visibility = View.VISIBLE

        //Set Animation
        val animation = AnimationSet(true)
        animation.addAnimation(
            TranslateAnimation(
                0f,
                0f,
                15f,
                -2f
            )
        )

        animation.duration = 1000
        animation.interpolator = OvershootInterpolator(25f)
        mIndicatorView.startAnimation(animation)
        view.startAnimation(animation)

        //Reset the Constraints on the NavView
        val set = ConstraintSet()
        set.clone(mRootLayout)
        set.clear(view.id, ConstraintSet.TOP)
        set.connect(view.id, ConstraintSet.BOTTOM, mRootLayout.id, ConstraintSet.BOTTOM, 28)
        set.applyTo(mRootLayout)
    }
}
