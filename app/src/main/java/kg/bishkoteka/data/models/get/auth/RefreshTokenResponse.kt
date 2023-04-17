package kg.bishkoteka.data.models.get.auth

import com.google.gson.annotations.SerializedName

data class RefreshTokenResponse(
    @SerializedName("refresh")
    val refresh: String
)