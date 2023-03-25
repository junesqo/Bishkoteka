package kg.bishkoteka.data.remote.dto.events

import com.google.gson.annotations.SerializedName
import kg.bishkoteka.core.network.paging.DataMapper

data class Category(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
) : java.io.Serializable
