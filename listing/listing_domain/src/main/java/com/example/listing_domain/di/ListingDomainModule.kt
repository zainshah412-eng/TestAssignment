package com.example.listing_domain.di

import com.example.listing_domain.repository.ListingRepository
import com.example.listing_domain.use_case.GetListingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object ListingDomainModule {
    @Provides
    fun providesGetListingUseCase(listingRepository: ListingRepository): GetListingUseCase {
        return GetListingUseCase(listingRepository)
    }

}