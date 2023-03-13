package kg.bishkoteka.ui.models

import kg.bishkoteka.core.network.paging.BaseDiffModel
import kg.bishkoteka.domain.models.CategoryModel

data class CategoryUi(
    override val id: Int,
    val title: String,
) : BaseDiffModel<Int>

fun CategoryModel.toUi() = CategoryUi(id, title)