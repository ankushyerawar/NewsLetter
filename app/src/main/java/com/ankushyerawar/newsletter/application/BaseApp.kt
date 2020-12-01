package com.ankushyerawar.newsletter.application

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.ankushyerawar.newsletter.data.NewsRepository
import com.ankushyerawar.newsletter.utils.AppConstants
import com.ankushyerawar.newsletter.utils.SharedPreferenceHelper
import com.treebo.internetavailabilitychecker.InternetAvailabilityChecker
import com.treebo.internetavailabilitychecker.InternetConnectivityListener

class BaseApp : Application(), InternetConnectivityListener {

    private lateinit var mInternetAvailabilityChecker: InternetAvailabilityChecker

    //----------------------------------------------------------------------------------------------

    override fun onCreate() {
        super.onCreate()
        mInternetAvailabilityChecker = InternetAvailabilityChecker.init(this)
        mInternetAvailabilityChecker.addInternetConnectivityListener(this)
    }

    //----------------------------------------------------------------------------------------------

    val preferences: SharedPreferences
    get() {return this.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE)}

    val repository: NewsRepository
    get() {return NewsRepository.getInstance(preferences)}

    //----------------------------------------------------------------------------------------------

    override fun onInternetConnectivityChanged(isConnected: Boolean) {
        SharedPreferenceHelper.setBoolean(preferences, AppConstants.INTERNET, isConnected)
    }

    override fun onTerminate() {
        super.onTerminate()
        mInternetAvailabilityChecker.removeAllInternetConnectivityChangeListeners()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mInternetAvailabilityChecker.removeAllInternetConnectivityChangeListeners()
    }
}