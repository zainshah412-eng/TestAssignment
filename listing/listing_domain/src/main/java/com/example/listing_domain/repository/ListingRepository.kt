package com.example.listing_domain.repository

import com.example.listing_domain.model.University

interface ListingRepository {
    suspend fun getUniversity():List<University>
}