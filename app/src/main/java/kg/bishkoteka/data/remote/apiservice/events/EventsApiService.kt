package kg.bishkoteka.data.remote.apiservice.events

import kg.bishkoteka.data.models.get.events.CategoryResponse
import kg.bishkoteka.data.models.get.events.OnetimeEventResponse
import kg.bishkoteka.data.models.post.events.CommentRequest
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface EventsApiService {

    @GET("events/categories/")
    suspend fun getCategories(): Response<List<CategoryResponse>>

    @GET("events/onetime/")
    suspend fun getEvents(
        @Query("offset") offset: Int = 0,
//        @Query("page") page: Int?,
        @Query("title") title: String?,
    ): Response<OnetimeEventResponse>

    @GET("events/onetime/{id}")
    suspend fun getEventById(
        @Path("id") id: Int,
    ): Response<OnetimeEventResponse>

    @POST("events/{id}/comment/")
    suspend fun addComment(
        @Path("id") id: Int,
        @Body commentRequest: CommentRequest
    ): Response<Unit>

//    @POST("organization/{id}/events/onetime/create/")
//    suspend fun createEvent(
//        @Path("id") organizationId: Int,
//        @Body eventCreateRequest: EventCreateRequest,
//    ): Response<Unit>

    @Multipart
    @POST("organization/{id}/events/onetime/create/")
    suspend fun createEvent(
        @Path("id") id: Int,
        @PartMap() partMap: MutableMap<String,RequestBody>,
//        @Part file: MultipartBody.Part
    ):Response<Unit>

//    @POST("organization/{id}/events/onetime/create/")
//    suspend fun createEvent(
//        @Path("id") organizationId: Int,
//        @Part("title") title: RequestBody,
//        @Part("description") description: RequestBody,
//        @Part("price") price: RequestBody,
//        @Part("location") location: RequestBody,
//        @Part("entry") entry: RequestBody,
//        @Part("start_time") startTime: RequestBody,
//        @Part("end_time") endTime: RequestBody
//    ): Response<Unit>

//    @Multipart
//    @POST("organization/{id}/events/onetime/create/")
//    suspend fun createEvent(
//        @Path("id") organizationId: Int,
//        @Part("create") eventCreateRequest: EventCreateRequest,
//    ): Response<Unit>



}