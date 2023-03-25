package kg.bishkoteka.data.remote.dto.events

import com.google.gson.annotations.SerializedName
import kg.bishkoteka.core.network.paging.BaseDiffModel
import kg.bishkoteka.core.network.paging.DataMapper

data class EventModel(
//    @SerializedName("id")
    val id: Int,
//    @SerializedName("title")
    val title: String,
//    @SerializedName("description")
    val description: String,
//    @SerializedName("price")
    val price: Int,
//    @SerializedName("organization")
    val organization: String,
//    @SerializedName("location")
    val location: String,
//    @SerializedName("entry")
    val entry: String,
//    @SerializedName("start_time")
    val start_time: Long,
//    @SerializedName("end_time")
    val end_time: Long,
//    @SerializedName("categories")
    val categories: List<Category>?,
//    @SerializedName("comments")
    val comments: List<Comment>?,
//    @SerializedName("promotion")
    val promotion: Promotion?
) : BaseDiffModel<Int> {
    override val idDif: Int
        get() = this.id
}


//
//) : DataMapper<EventModel> {
//    override fun toDomain() = EventModel(
//        id,
//        title,
//        description,
//        price,
//        organization.toDomain(),
//        location,
//        entry,
//        start_time,
//        end_time,
//        categories?.map { it.toDomain() },
//        comments?.map { it.toDomain() },
//        promotion?.toDomain()
//    )
//}
