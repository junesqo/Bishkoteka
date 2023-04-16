package kg.bishkoteka.data.remote.dto.organization

import com.google.gson.annotations.SerializedName
import kg.bishkoteka.core.network.paging.BaseDiffModel
import kg.bishkoteka.data.remote.dto.events.EventModel

data class OrganizationDto(
    val id: Int,
    val user_id: Int,
    val name: String,
    val description: String,
    val type: String,
    val phone_number: String,
    val address: String,
    val insta_link: String,
    val events: List<EventModel>,
    val following_count: Int
) : BaseDiffModel<Int> {
    override val idDif: Int
        get() = this.id
}