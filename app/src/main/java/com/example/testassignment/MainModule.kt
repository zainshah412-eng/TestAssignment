package com.example.testassignment

import android.content.Context
import com.example.common_utlis.Navigator
import com.example.listing_data.room.ListingDAO
import com.example.testassignment.navigation.DefaultNavigator
import com.example.testassignment.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MainModule {

    @Provides
    @Singleton
    fun provideProvider(): Navigator.Provider {
        return DefaultNavigator()
    }

    @Provides
    @Singleton
    fun provideListingDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideListingDAO(appDatabase: AppDatabase): ListingDAO {
        return appDatabase.getListing()
    }
}