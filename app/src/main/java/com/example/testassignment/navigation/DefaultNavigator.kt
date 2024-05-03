package com.example.testassignment.navigation

import com.example.common_utlis.Activities
import com.example.common_utlis.Navigator
import com.example.detail_presentation.GoToDetailActivity
import com.example.listing_presentation.GoToListingActivity

class DefaultNavigator : Navigator.Provider {
    override fun getActivities(activities: Activities): Navigator {
        return when (activities) {
            Activities.ListingActivity -> {
                GoToListingActivity
            }
            Activities.DetailActivity -> {
                GoToDetailActivity
            }
        }
    }

}