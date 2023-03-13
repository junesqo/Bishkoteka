package kg.bishkoteka.domain.models

import com.google.gson.annotations.SerializedName

data class OrganizationModel(
    val id: Int,
    val name: String,
    val description: String,
    val type: String,
    val phone_number: String,
    val address: String,
    val insta_link: String
)
