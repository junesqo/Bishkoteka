package kg.bishkoteka.remote.dto

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
    @SerializedName("date_of_birth")
    val birthdate: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("password2")
    val confirmPassword: String
)