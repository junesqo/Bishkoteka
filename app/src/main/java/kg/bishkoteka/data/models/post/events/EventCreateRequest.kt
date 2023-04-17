package kg.bishkoteka.data.models.post.events

import com.google.gson.annotations.SerializedName

data class EventCreateRequest(
    @SerializedName("id")
    val organizationId: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("entry")
    val entry: String,
    @SerializedName("start_time")
    val start_time: String,
    @SerializedName("end_time")
    val end_time: String
)