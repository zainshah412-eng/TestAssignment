package com.example.listing_presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common_utlis.Resource
import com.example.listing_domain.use_case.GetListingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ListingViewModel @Inject constructor(private val getListingUseCase: GetListingUseCase) :
    ViewModel() {
    private val _listing = MutableStateFlow(ListingState())
    val listing: StateFlow<ListingState> = _listing

    init {
        getListing()
    }

    fun getListing() {
        getListingUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    _listing.value = ListingState(isLoading = true)
                }
                is Resource.Error -> {
                    _listing.value = ListingState(error = it.message)
                }
                is Resource.Success -> {
                    _listing.value = ListingState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}