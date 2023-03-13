package kg.bishkoteka.data.remote.dto.events

import com.google.gson.annotations.SerializedName
import kg.bishkoteka.core.network.paging.DataMapper
import kg.bishkoteka.domain.models.CategoryModel

data class CategoryDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
) : DataMapper<CategoryModel> {
    override fun toDomain() = CategoryModel(id, title)
}
