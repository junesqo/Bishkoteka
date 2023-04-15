package kg.bishkoteka.data.remote.dto.organization

import com.google.gson.annotations.SerializedName
import kg.bishkoteka.core.network.paging.BaseDiffModel

data class OrganizationDto(
    val id: Int,
    val user_id: Int,
    val name: String,
    val description: String,
    val type: String,
    val phone_number: String,
    val address: String,
    val insta_link: String
) : BaseDiffModel<Int> {
    override val idDif: Int
        get() = this.id
}