package kg.bishkoteka.data.remote.dto.auth

import com.google.gson.annotations.SerializedName

data class SignUpDto(
    @SerializedName("first_name")
    val name: String,
    @SerializedName("last_name")
    val lastname: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("date_of_birth")
    val date_of_birth: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("password2")
    val confirmPassword: String,
    @SerializedName("interests_ids")
    var interests_ids: List<Int>
)