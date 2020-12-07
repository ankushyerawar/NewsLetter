package com.ankushyerawar.newsletter.data.remote.apiconfig

import com.ankushyerawar.newsletter.data.model.Headlines
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(HEADLINE)
    suspend fun getHeadlineNews(@Query(COUNTRY) country: String, @Query(API_KEY_PARAMETER) apiKey: String): Response<Headlines>

    companion object{
        //Base Url
        const val BASE_URL = "https://newsapi.org/v2/"

        //Parameters
        const val COUNTRY = "country"
        const val API_KEY_PARAMETER = "apiKey"

        //Headline News
        const val HEADLINE = "top-headlines"
    }
}