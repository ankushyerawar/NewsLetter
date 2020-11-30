package com.ankushyerawar.newsletter.ui.home

import android.app.Application
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ankushyerawar.newsletter.application.BaseApp
import com.ankushyerawar.newsletter.utils.AppConstants
import com.ankushyerawar.newsletter.utils.SharedPreferenceHelper

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private var sharedPreferences: SharedPreferences = (application as(BaseApp)).getPreferences()

    public fun isInternetAvailable(): Boolean {
        return SharedPreferenceHelper.getBoolean(sharedPreferences, AppConstants.INTERNET, false)
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}