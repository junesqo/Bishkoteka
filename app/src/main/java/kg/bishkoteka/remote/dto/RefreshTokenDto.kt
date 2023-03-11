package kg.bishkoteka.remote.dto

import com.google.gson.annotations.SerializedName

data class RefreshTokenDto(
    @SerializedName("refresh")
    val refresh: String
)