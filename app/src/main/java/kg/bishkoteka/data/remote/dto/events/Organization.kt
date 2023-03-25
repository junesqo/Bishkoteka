package kg.bishkoteka.data.remote.dto.events

import com.google.gson.annotations.SerializedName

data class Organization(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("phone_number")
    val phone_number: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("insta_link")
    val insta_link: String
) : java.io.Serializable