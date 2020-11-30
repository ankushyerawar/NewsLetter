package com.ankushyerawar.newsletter.utils

import android.content.SharedPreferences

object SharedPreferenceHelper {

    fun setString(
        pref: SharedPreferences,
        key: String?,
        value: String?
    ) {
        val editor = pref.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun setInt(
        pref: SharedPreferences,
        key: String?,
        value: Int
    ) {
        val editor = pref.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun setLong(
        pref: SharedPreferences,
        key: String?,
        value: Long
    ) {
        val editor = pref.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    fun setFloat(
        pref: SharedPreferences,
        key: String?,
        value: Float
    ) {
        val editor = pref.edit()
        editor.putFloat(key, value)
        editor.apply()
    }

    fun setBoolean(
        pref: SharedPreferences,
        key: String?,
        value: Boolean
    ) {
        val editor = pref.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getString(
        pref: SharedPreferences,
        key: String?,
        defValue: String?
    ): String? {
        return pref.getString(key, defValue)
    }

    fun getInt(pref: SharedPreferences, key: String?, defValue: Int): Int {
        return pref.getInt(key, defValue)
    }

    fun getLong(
        pref: SharedPreferences,
        key: String?,
        defValue: Long
    ): Long {
        return pref.getLong(key, defValue)
    }

    fun getFloat(
        pref: SharedPreferences,
        key: String?,
        defValue: Float
    ): Float {
        return pref.getFloat(key, defValue)
    }

    fun getBoolean(
        pref: SharedPreferences,
        key: String?,
        defValue: Boolean
    ): Boolean {
        return pref.getBoolean(key, defValue)
    }

    fun removeString(pref: SharedPreferences, key: String?) {
        val editor = pref.edit()
        editor.remove(key)
        editor.apply()
    }
}