package kg.bishkoteka.data.remote.apiservice.events

import kg.bishkoteka.data.remote.dto.events.CategoryModel
import kg.bishkoteka.data.remote.dto.events.EventModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

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
}