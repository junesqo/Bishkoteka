package kg.bishkoteka.ui.models

import kg.bishkoteka.core.network.paging.BaseDiffModel
import kg.bishkoteka.domain.models.EventModel

data class EventUi(
    override val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val organization: OrganizationUi,
    val location: String,
    val entry: String,
    val start_time: Long,
    val end_time: Long,
    val categories: List<CategoryUi>?,
    val comments: List<CommentUi>?,
    val promotion: PromotionUi?

) : BaseDiffModel<Int>

fun EventModel.toUi() = EventUi(
    id,
    title,
    description,
    price,
    organization.toUi(),
    location,
    entry,
    start_time,
    end_time,
    categories?.map { it.toUi() },
    comments?.map { it.toUi() },
    promotion?.toUi()
)
