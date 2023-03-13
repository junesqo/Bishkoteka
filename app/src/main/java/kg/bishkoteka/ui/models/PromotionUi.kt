package kg.bishkoteka.ui.models

import kg.bishkoteka.core.network.paging.BaseDiffModel
import kg.bishkoteka.domain.models.PromotionModel

data class PromotionUi(
    override val id: Int,
    val title: String,
    val price: Int
) : BaseDiffModel<Int>

fun PromotionModel.toUi() = PromotionUi(
    id, title, price
)
