package com.example.listing_domain.use_case

import com.example.common_utlis.Resource
import com.example.listing_domain.model.University
import com.example.listing_domain.repository.ListingRepository
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow

class GetListingUseCase(private val listingRepository: ListingRepository) {

    operator fun invoke(): kotlinx.coroutines.flow.Flow<Resource<List<University>>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data=listingRepository.getUniversity()))
        }catch (e:Exception){
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}