package kg.bishkoteka.domain.models

data class EventModel(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val organization: OrganizationModel,
    val location: String,
    val entry: String,
    val start_time: Long,
    val end_time: Long,
    val categories: List<CategoryModel>?,
    val comments: List<CommentModel>?,
    val promotion: PromotionModel?

)
