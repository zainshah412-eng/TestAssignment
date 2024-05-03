package com.example.listing_data.di

import com.example.listing_data.network.UniversityApiService
import com.example.listing_data.repository.ListingRepoImpl
import com.example.listing_data.room.ListingDAO
import com.example.listing_domain.repository.ListingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@InstallIn(SingletonComponent::class)
@Module
object ListingDataModule {

    @Provides
    fun provideUniversityApiService(retrofit: Retrofit): UniversityApiService {
        return retrofit.create(UniversityApiService::class.java)
    }

    @Provides
    fun providesUniversityRepository(
        universityApiService: UniversityApiService,
        listingDAO: ListingDAO
    ): ListingRepository {
        return ListingRepoImpl(universityApiService, listingDAO)
    }
}