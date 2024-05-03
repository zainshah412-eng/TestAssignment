package com.example.listing_data.model

import com.google.gson.annotations.SerializedName


data class UniversityDTO(
    @SerializedName("alpha_two_code")
    var alphaTwoCode: String?,
    @SerializedName("country")
    var country: String?,
    @SerializedName("domains")
    var domains: List<String?>?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("state-province")
    var stateProvince: String?,
    @SerializedName("web_pages")
    var webPages: List<String?>?
)


