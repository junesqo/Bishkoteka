package kg.bishkoteka.data.remote.dto.events

import com.google.gson.annotations.SerializedName
import kg.bishkoteka.core.network.paging.DataMapper
import kg.bishkoteka.domain.models.CommentModel
import kg.bishkoteka.domain.models.CustomUserModel

data class CommentDto (
    @SerializedName("id")
    val id: Int,
    @SerializedName("user")
    val user: CustomUserDto,
    @SerializedName("text")
    val text: String
) : DataMapper<CommentModel> {
    override fun toDomain() = CommentModel(id, user.toDomain(), text)
}
