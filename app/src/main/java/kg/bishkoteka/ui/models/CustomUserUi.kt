package kg.bishkoteka.ui.models

import kg.bishkoteka.core.network.paging.BaseDiffModel
import kg.bishkoteka.domain.models.CustomUserModel

data class CustomUserUi (
    override val id: Int,
    val email: String,
    val username: String,
    val first_name: String,
    val last_name: String
) : BaseDiffModel<Int>

fun CustomUserModel.toUi() = CustomUserUi(
    id, email, username, first_name, last_name
)
