package com.ankushyerawar.newsletter.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ankushyerawar.newsletter.application.BaseApp
import com.ankushyerawar.newsletter.utils.AppConstants
import com.ankushyerawar.newsletter.utils.SharedPreferenceHelper

class SplashViewModel(application: Application) : AndroidViewModel(application) {

    private val mSharedPreferences = (application as (BaseApp)).preferences

    val isInternetAvailable: Boolean
        get() { return SharedPreferenceHelper.getBoolean(mSharedPreferences, AppConstants.INTERNET, false)}

    var showSplashFragment: Boolean
        set(value) {
            SharedPreferenceHelper.setBoolean(mSharedPreferences, AppConstants.SPLASH_SCREEN, value)
        }
        get() = SharedPreferenceHelper.getBoolean(
            mSharedPreferences,
            AppConstants.SPLASH_SCREEN,
            false
        )
}