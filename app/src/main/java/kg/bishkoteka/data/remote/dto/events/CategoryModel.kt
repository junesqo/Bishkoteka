package kg.bishkoteka.data.remote.dto.events

import kg.bishkoteka.core.network.paging.BaseDiffModel

data class CategoryModel(
//    @SerializedName("id")
    val id: Int,
//    @SerializedName("title")
    val title: String,
)  : BaseDiffModel<Int> {
    override val idDif: Int
        get() = this.id
}
