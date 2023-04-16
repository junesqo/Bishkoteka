package kg.bishkoteka.data.remote.dto.user

import com.google.gson.annotations.SerializedName
import kg.bishkoteka.data.remote.dto.events.CategoryModel
import kg.bishkoteka.data.remote.dto.events.EventModel

data class UserDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("first_name")
    val first_name: String,
    @SerializedName("last_name")
    val last_name: String,
    @SerializedName("following_count")
    val following_count: Int
)