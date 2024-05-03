package com.example.listing_data.mapper

import com.example.listing_data.model.UniversityDTO
import com.example.listing_domain.model.University

fun UniversityDTO.toDomainUniversity(): University {
    return University(
        alphaTwoCode = this.alphaTwoCode,
        country = this.country,
        name = this.name ?: "",
        stateProvince = this.stateProvince ?: "",
        webPages = let {
            this.webPages?.get(0)?.toString()
        }
    )
}