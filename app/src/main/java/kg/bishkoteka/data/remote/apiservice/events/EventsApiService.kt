package kg.bishkoteka.data.remote.apiservice.events

import kg.bishkoteka.data.models.get.events.CategoryResponse
import kg.bishkoteka.data.models.post.events.EventCreateRequest
import kg.bishkoteka.data.models.get.events.EventResponse
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
    ): Response<EventResponse>

    @GET("events/onetime/{id}")
    suspend fun getEventById(
        @Path("id") id: Int,
    ): Response<EventResponse>

//    @POST("organization/{id}/events/onetime/create/")
//    suspend fun createEvent(
//        @Header("Content-Type") contentType: String,
//        @Path("id") organizationId: Int,
//        @Body createEventDto: CreateEventDto,
//    ): Response<Unit>


    @Multipart
    @POST("organization/{id}/events/onetime/create/")
    suspend fun createEvent(
        @Path("id") organizationId: Int,
        @Part("create") eventCreateRequest: EventCreateRequest,
    ): Response<Unit>

}