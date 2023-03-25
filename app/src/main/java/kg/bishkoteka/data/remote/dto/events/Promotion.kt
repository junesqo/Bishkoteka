package kg.bishkoteka.data.remote.dto.events

import com.google.gson.annotations.SerializedName

data class Promotion(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: Int
) : java.io.Serializable
