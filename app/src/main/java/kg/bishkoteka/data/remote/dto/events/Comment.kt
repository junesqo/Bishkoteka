package kg.bishkoteka.data.remote.dto.events

import com.google.gson.annotations.SerializedName

data class Comment (
    @SerializedName("id")
    val id: Int,
    @SerializedName("user")
    val user: CustomUser,
    @SerializedName("text")
    val text: String
) : java.io.Serializable