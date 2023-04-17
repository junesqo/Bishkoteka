package kg.bishkoteka.data.models.get.events

import com.google.gson.annotations.SerializedName

data class PromotionResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: Int
) : java.io.Serializable
