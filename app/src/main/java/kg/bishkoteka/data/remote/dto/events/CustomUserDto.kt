package kg.bishkoteka.data.remote.dto.events

import com.google.gson.annotations.SerializedName
import kg.bishkoteka.core.network.paging.DataMapper
import kg.bishkoteka.domain.models.CustomUserModel

data class CustomUserDto (
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
) : DataMapper<CustomUserModel> {
    override fun toDomain() = CustomUserModel(id, email, username, first_name, last_name)
}
