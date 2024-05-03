package com.example.listing_presentation.viewmodel

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.common_utlis.Constants
import com.example.listing_presentation.ListingViewModel
import com.google.gson.GsonBuilder
import junit.framework.TestCase
import okhttp3.OkHttpClient
import org.junit.Before
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(AndroidJUnit4::class)
class ListingViewModelTest : TestCase() {
    private lateinit var context: Context
    private lateinit var viewModel: ListingViewModel

    @Before
    public override fun setUp() {
        super.setUp()

        context = ApplicationProvider.getApplicationContext<Context>()
        val gson = GsonBuilder().create()
        val client = OkHttpClient.Builder().build()

        val retrofit =
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()


    }
}