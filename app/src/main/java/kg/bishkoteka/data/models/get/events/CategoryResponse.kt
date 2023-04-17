package kg.bishkoteka.data.models.get.events

import kg.bishkoteka.core.network.paging.BaseDiffModel

data class CategoryResponse(
    val id: Int,
    val title: String,
)  : BaseDiffModel<Int> {
    override val idDif: Int
        get() = this.id
}
