package com.ankushyerawar.newsletter.ui.activity

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationSet
import android.view.animation.OvershootInterpolator
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.ankushyerawar.newsletter.R
import com.ankushyerawar.newsletter.ui.dashboard.DashboardFragment
import com.ankushyerawar.newsletter.ui.fragment.HeadlineFragment
import com.ankushyerawar.newsletter.ui.notifications.NotificationsFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mNavHostFragment: Fragment
    private lateinit var mNavController: NavController

    private var isAnimated: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mNavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)!!
        mNavController = findNavController(R.id.nav_host_fragment)

        setUpNav()
    }

    //Back Stack Handling
    override fun onBackPressed() {
        val currentFragment = nav_host_fragment.childFragmentManager.fragments[0]

        //if the current fragment is Home fragment finish the Activity
        if (currentFragment is HeadlineFragment) {
            finish()
        } else if (currentFragment is DashboardFragment ||
            currentFragment is NotificationsFragment) {
            mNavController.popBackStack(R.id.navigation_headline, false)
        } else {
            super.onBackPressed()
        }
    }

    //Navigation Set-Up
    private fun setUpNav() {
        setSupportActionBar(toolbar)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_headline,
                R.id.navigation_dashboard,
                R.id.navigation_notifications
            )
        )

        toolbar.setupWithNavController(mNavController, appBarConfiguration)
        navView.setupWithNavController(mNavController)

        onFragmentToolbarChanged()
    }

    //Handling Of Toolbar Changes
    private fun onFragmentToolbarChanged() {
        mNavController.addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {
                R.id.navigation_splash -> toolbar.visibility = View.GONE
                R.id.navigation_launch -> toolbar.visibility = View.GONE
                R.id.navigation_headline -> {
                    toolbar.visibility = View.VISIBLE
                    if (!isAnimated)
                        animateBottomView(navView)
                    indicatorView.setSelectedIndex(0)
                }
                R.id.navigation_dashboard -> indicatorView.setSelectedIndex(1)
                R.id.navigation_notifications -> indicatorView.setSelectedIndex(2)
                else -> toolbar.visibility = View.VISIBLE
            }
        }
    }

    //Animate Bottom Navigation View
    private fun animateBottomView(view: View) {
        isAnimated = true
        view.visibility = View.VISIBLE

        //Set Animation
        val animation = AnimationSet(true)
        animation.addAnimation(
            TranslateAnimation(
                animX,
                animX,
                animFromY,
                animToY
            )
        )

        animation.duration = duration
        animation.interpolator = OvershootInterpolator(interpolatorTension)
        indicatorView.startAnimation(animation)
        view.startAnimation(animation)

        //Reset the Constraints on the NavView
        val set = ConstraintSet()
        set.clone(container)
        set.clear(view.id, ConstraintSet.TOP)
        set.connect(
            view.id,
            ConstraintSet.BOTTOM,
            container.id,
            ConstraintSet.BOTTOM,
            bottomMargin
        )
        set.applyTo(container)
    }

    //Constant Values Used in Activity
    companion object {
        const val duration: Long = 1000
        const val interpolatorTension: Float = 25f
        const val animX: Float = 0f
        const val animFromY: Float = 15f
        const val animToY: Float = -2f
        const val bottomMargin: Int = 28
    }
}
