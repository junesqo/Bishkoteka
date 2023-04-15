package kg.bishkoteka.data.remote.dto.events

import com.google.gson.annotations.SerializedName

data class CustomUser (
    @SerializedName("id")
    val id: Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("first_name")
    val first_name: String,
    @SerializedName("last_name")
    val last_name: String
) : java.io.Serializable
