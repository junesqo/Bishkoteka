package kg.bishkoteka.data.models.get.events

import kg.bishkoteka.core.network.paging.BaseDiffModel
import kg.bishkoteka.data.models.get.profile.UserResponse

data class RegularEventResponse(
    val id: Int,
    val moderation_status: String,
    val title: String,
    val description: String,
    val price: Int,
    val organization: String,
    val location: String,
    val entry: String,
    val start_time: String,
    val occurrence_days: String,
    val categories: List<CategoryResponse>?,
    val interested: List<UserResponse>?,
    val comments: List<CommentResponse>?,
    val promotions: List<PromotionResponse>?
) : BaseDiffModel<Int> {
    override val idDif: Int
        get() = this.id
}
