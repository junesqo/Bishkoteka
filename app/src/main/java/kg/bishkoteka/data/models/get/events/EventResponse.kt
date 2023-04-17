package kg.bishkoteka.data.models.get.events

import kg.bishkoteka.core.network.paging.BaseDiffModel
import kg.bishkoteka.data.models.get.profile.UserResponse

data class EventResponse(
    val id: Int,
    val moderation_status: String,
    val title: String,
    val description: String,
    val price: Int,
    val organization: String,
    val location: String,
    val entry: String,
    val start_time: Long,
    val end_time: Long,
    val categories: List<CategoryResponse>?,
    val interested: List<UserResponse>?,
    val comments: List<CommentResponse>?,
    val promotionResponse: PromotionResponse?
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
