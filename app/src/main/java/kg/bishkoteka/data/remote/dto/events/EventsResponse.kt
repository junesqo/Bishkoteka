package kg.bishkoteka.data.remote.dto.events

import kg.bishkoteka.core.network.paging.DataMapper

data class EventsResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<EventModel>,
) : DataMapper<EventModel> {
    override fun responseToModel(): List<EventModel> = this.results
}

//data class EventsResponseDto(
//    @SerializedName("count")
//    val count: Int,
//    @SerializedName("next")
//    val next: String,
//    @SerializedName("previous")
//    val previous: Any,
//    @SerializedName("results")
//    val results: List<EventDto>,
//) : DataMapper<EventsResponseModel>
//{
//    override fun toDomain() = EventsResponseModel(
//        count, next, previous, results.map {it.toDomain()
//        }
//    )
//}


//{
//    override fun toDomain(): List<EventsResponseModel> = this.results
//}


//data class EventDto(
//    @SerializedName("id")
//    val id: Int,
//    @SerializedName("title")
//    val title: String,
//    @SerializedName("description")
//    val description: String,
//    @SerializedName("price")
//    val price: Int,
//    @SerializedName("organization")
//    val organization: Organization,
//    @SerializedName("location")
//    val location: String,
//    @SerializedName("entry")
//    val entry: String,
//    @SerializedName("start_time")
//    val start_time: Long,
//    @SerializedName("end_time")
//    val end_time: Long,
//    @SerializedName("categories")
//    val categories: List<CategoryDto>?,
//    @SerializedName("comments")
//    val comments: List<CommentDto>?,
//    @SerializedName("promotion")
//    val promotion: PromotionDto?
//
//) : DataMapper<EventModel>{
//    override fun toDomain() = EventModel(
//        id,
//        title,
//        description,
//        price,
//        organization,
//        location,
//        entry,
//        start_time,
//        end_time,
//        categories?.map { it.toDomain() },
//        comments?.map { it.toDomain() },
//        promotion?.toDomain()
//    )
//}

//data class CategoryDto(
//    @SerializedName("id")
//    val id: Int,
//    @SerializedName("title")
//    val title: String,
//) : DataMapper<CategoryModel> {
//    override fun toDomain() = CategoryModel(id, title)
//}

//data class CommentDto (
//    @SerializedName("id")
//    val id: Int,
//    @SerializedName("user")
//    val user: CustomUserDto,
//    @SerializedName("text")
//    val text: String
//) : DataMapper<CommentModel> {
//    override fun toDomain() = CommentModel(id, user.toDomain(), text)
//}

//data class CustomUserDto (
//    @SerializedName("id")
//    val id: Int,
//    @SerializedName("email")
//    val email: String,
//    @SerializedName("username")
//    val username: String,
//    @SerializedName("first_name")
//    val first_name: String,
//    @SerializedName("last_name")
//    val last_name: String
//) : DataMapper<CustomUserModel> {
//    override fun toDomain() = CustomUserModel(id, email, username, first_name, last_name)
//}

//data class PromotionDto(
//    @SerializedName("id")
//    val id: Int,
//    @SerializedName("title")
//    val title: String,
//    @SerializedName("price")
//    val price: Int
//): DataMapper<PromotionModel> {
//    override fun toDomain() = PromotionModel(id, title, price)
//}