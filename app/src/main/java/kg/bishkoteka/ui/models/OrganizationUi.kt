package kg.bishkoteka.ui.models

import kg.bishkoteka.core.network.paging.BaseDiffModel
import kg.bishkoteka.domain.models.EventModel
import kg.bishkoteka.domain.models.OrganizationModel

data class OrganizationUi(
    override val id: Int,
    val name: String,
    val description: String,
    val type: String,
    val phone_number: String,
    val address: String,
    val insta_link: String
) : BaseDiffModel<Int>

fun OrganizationModel.toUi() = OrganizationUi(
    id, name, description, type, phone_number, address, insta_link
)
