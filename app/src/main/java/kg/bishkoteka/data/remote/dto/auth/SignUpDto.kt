package kg.bishkoteka.data.remote.dto.auth

import com.google.gson.annotations.SerializedName

data class SignUpDto(
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("password2")
    val confirmPassword: String,
)