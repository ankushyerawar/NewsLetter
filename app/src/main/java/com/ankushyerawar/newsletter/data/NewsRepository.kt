package com.ankushyerawar.newsletter.data

import android.content.SharedPreferences

class NewsRepository private constructor(preferences: SharedPreferences) {

    companion object {
        @Volatile
        private var INSTANCE: NewsRepository? = null

        fun getInstance(sharedPreferences: SharedPreferences): NewsRepository {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = NewsRepository(preferences = sharedPreferences)
                INSTANCE = instance
                return instance
            }
        }
    }
}