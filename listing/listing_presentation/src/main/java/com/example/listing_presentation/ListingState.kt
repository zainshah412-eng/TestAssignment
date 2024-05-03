package com.example.listing_presentation

import com.example.listing_domain.model.University

data class ListingState(
    val isLoading:Boolean=false,
    val error:String="",
    val data:List<University>?=null
)
