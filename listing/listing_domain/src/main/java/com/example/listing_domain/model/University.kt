package com.example.listing_domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class University(
    @PrimaryKey(autoGenerate = false)
    var name: String,
    var stateProvince: String?,
    var country: String?,
    var alphaTwoCode: String?,
    var webPages: String?,

)
