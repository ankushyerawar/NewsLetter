package com.ankushyerawar.newsletter.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ankushyerawar.newsletter.application.BaseApp
import com.ankushyerawar.newsletter.data.model.Splash
import com.ankushyerawar.newsletter.utils.AppConstants
import com.ankushyerawar.newsletter.utils.SharedPreferenceHelper

class SplashViewModel(application: Application) : AndroidViewModel(application) {

    //get required fields
    private val mSharedPreferences = (application as (BaseApp)).preferences

    //check if Network is available
    val isInternetAvailable: Boolean
        get() { return SharedPreferenceHelper.getBoolean(mSharedPreferences, AppConstants.INTERNET, false)}

    //Show Splash screen only once
    var showSplashFragment: Boolean
        set(value) {
            SharedPreferenceHelper.setBoolean(mSharedPreferences, AppConstants.SPLASH_SCREEN, value)
        }
        get() = SharedPreferenceHelper.getBoolean(
            mSharedPreferences,
            AppConstants.SPLASH_SCREEN,
            false
        )

    //Data to be shown on Splash screen
    var showNext: Int = 0

    var splashList: List<Splash> ?= null
    set(value) {
        field = value
    }
    get() = field

}