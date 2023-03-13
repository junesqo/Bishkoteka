package kg.bishkoteka.domain.models

data class CommentModel (
    val id: Int,
    val user: CustomUserModel,
    val text: String
)
