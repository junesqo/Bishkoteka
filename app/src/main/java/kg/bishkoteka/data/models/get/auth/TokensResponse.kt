package kg.bishkoteka.data.models.get.auth

import com.google.gson.annotations.SerializedName

data class TokensResponse(
    @SerializedName("refresh")
    val refresh: String,
    @SerializedName("access")
    val access: String
)