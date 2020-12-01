package com.ankushyerawar.newsletter.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ankushyerawar.newsletter.application.BaseApp
import com.ankushyerawar.newsletter.utils.AppConstants
import com.ankushyerawar.newsletter.utils.SharedPreferenceHelper

class NewsViewModel(application: Application) : AndroidViewModel(application) {

    private val mNewsRepository = (application as (BaseApp)).repository
    private val mSharedPreferences = (application as (BaseApp)).preferences

    var isInternetAvailable: Boolean = false
        get() { return SharedPreferenceHelper.getBoolean(mSharedPreferences, AppConstants.INTERNET, false)}
}