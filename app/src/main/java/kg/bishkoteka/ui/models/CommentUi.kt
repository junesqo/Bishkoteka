package kg.bishkoteka.ui.models

import kg.bishkoteka.core.network.paging.BaseDiffModel
import kg.bishkoteka.domain.models.CommentModel


data class CommentUi (
    override val id: Int,
    val user: CustomUserUi,
    val text: String
) : BaseDiffModel<Int>

fun CommentModel.toUi() = CommentUi(
    id, user.toUi(), text
)
