package kg.bishkoteka.data.remote.dto.auth

import com.google.gson.annotations.SerializedName

data class RefreshTokenDto(
    @SerializedName("refresh")
    val refresh: String
)