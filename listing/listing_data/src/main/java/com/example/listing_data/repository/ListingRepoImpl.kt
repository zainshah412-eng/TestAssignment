package com.example.listing_data.repository

import android.util.Log
import com.example.listing_data.mapper.toDomainUniversity
import com.example.listing_data.network.UniversityApiService
import com.example.listing_data.room.ListingDAO
import com.example.listing_domain.model.University
import com.example.listing_domain.repository.ListingRepository

class ListingRepoImpl(
    private val universityApiService: UniversityApiService,
    private val listingDAO: ListingDAO
) : ListingRepository {
    override suspend fun getUniversity(): List<University> {
        return try {
            val temp = universityApiService.getUniversities().map { it.toDomainUniversity() }
            listingDAO.insertList(temp)
            listingDAO.getAllListing()
        } catch (e: Exception) {
            listingDAO.getAllListing()
        }
    }
}