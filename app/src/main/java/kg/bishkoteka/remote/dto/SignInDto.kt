package kg.bishkoteka.remote.dto

import com.google.gson.annotations.SerializedName

data class SignInDto(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
)