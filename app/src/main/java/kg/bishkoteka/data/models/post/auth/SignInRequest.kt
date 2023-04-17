package kg.bishkoteka.data.models.post.auth

import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
)