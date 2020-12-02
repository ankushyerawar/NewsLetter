package com.ankushyerawar.newsletter.utils

import com.ankushyerawar.newsletter.BuildConfig

class AppConstants {

    companion object{
        //Shared Pref
        const val PREF_NAME: String = "NEWS_LETTER_PREF"
        const val INTERNET: String = "PREF_INTERNET"
        const val SPLASH_SCREEN = "PREF_SPLASH"

        //API Key
        const val API_KEY = BuildConfig.API_KEY

    }
}