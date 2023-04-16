package kg.bishkoteka.data.remote.apiservice.events

import kg.bishkoteka.data.remote.dto.events.CategoryModel
import kg.bishkoteka.data.remote.dto.events.CreateEventDto
import kg.bishkoteka.data.remote.dto.events.EventModel
import retrofit2.Response
import retrofit2.http.*

interface EventsApiService {

    @GET("events/categories/")
    suspend fun getCategories(): Response<List<CategoryModel>>

    @GET("events/onetime/")
    suspend fun getEvents(
        @Query("offset") offset: Int = 0,
//        @Query("page") page: Int?,
        @Query("title") title: String?,
    ): Response<EventModel>

    @GET("events/onetime/{id}")
    suspend fun getEventById(
        @Path("id") id: Int,
    ): Response<EventModel>

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
        @Part("create") createEventDto: CreateEventDto,
    ): Response<Unit>

}