package com.example.listing_data.network

import com.example.common_utlis.Constants
import com.example.listing_data.model.UniversityResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UniversityApiService {

    //http://universities.hipolabs.com/search?country=United%20Arab%20Emirates

    @GET("search")
    suspend fun getUniversities(
        @Query("country") country: String = Constants.COUNTRY_KEY
    ): UniversityResponse
}