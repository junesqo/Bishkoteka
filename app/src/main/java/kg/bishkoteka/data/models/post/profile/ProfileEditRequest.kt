package kg.bishkoteka.data.models.post.profile

import com.google.gson.annotations.SerializedName

data class ProfileEditRequest(
    val username: String,
    val first_name: String,
    val last_name: String,
)
