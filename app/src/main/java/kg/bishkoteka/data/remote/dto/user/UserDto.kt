package kg.bishkoteka.data.remote.dto.user

import com.google.gson.annotations.SerializedName
import kg.bishkoteka.data.remote.dto.events.EventModel

data class UserDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("favorite_tour")
    val favoriteTour: List<EventModel>
)