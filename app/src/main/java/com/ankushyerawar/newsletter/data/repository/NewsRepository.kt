package com.ankushyerawar.newsletter.data.repository

import android.content.SharedPreferences
import com.ankushyerawar.newsletter.data.remote.apiconfig.ApiManager
import com.ankushyerawar.newsletter.utils.AppConstants

class NewsRepository private constructor(preferences: SharedPreferences) {

    companion object {
        @Volatile
        private var INSTANCE: NewsRepository? = null

        fun getInstance(sharedPreferences: SharedPreferences): NewsRepository {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance =
                    NewsRepository(
                        preferences = sharedPreferences
                    )
                INSTANCE = instance
                return instance
            }
        }
    }
}