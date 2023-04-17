package kg.bishkoteka.data.models.get.organization

import kg.bishkoteka.core.network.paging.BaseDiffModel
import kg.bishkoteka.data.models.get.events.EventResponse

data class OrganizationResponse(
    val id: Int,
    val user_id: Int,
    val name: String,
    val description: String,
    val type: String,
    val phone_number: String,
    val address: String,
    val insta_link: String,
    val events: List<EventResponse>,
    val following_count: Int
) : BaseDiffModel<Int> {
    override val idDif: Int
        get() = this.id
}