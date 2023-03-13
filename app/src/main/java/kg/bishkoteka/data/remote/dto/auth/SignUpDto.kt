package kg.bishkoteka.data.remote.dto.auth

import com.google.gson.annotations.SerializedName

data class SignUpDto(
    @SerializedName("first_name")
    val name: String,
    @SerializedName("last_name")
    val lastname: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("password2")
    val confirmPassword: String
)