package com.ankushyerawar.newsletter.application

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
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

    fun getPreferences(): SharedPreferences {
        return this.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE)
    }

    //----------------------------------------------------------------------------------------------

    override fun onInternetConnectivityChanged(isConnected: Boolean) {
        SharedPreferenceHelper.setBoolean(getPreferences(), AppConstants.INTERNET, isConnected)
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