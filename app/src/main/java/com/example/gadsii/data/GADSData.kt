package com.example.gadsii.data

import com.google.gson.annotations.SerializedName

data class GADSData (
    var name: String,
    @SerializedName(value = "hours", alternate = ["score"])
    var progress: Int,
    var country: String,
    var badgeUrl: String
)
