package kg.bishkoteka.data.remote.apiservice.events

import kg.bishkoteka.data.remote.dto.events.EventModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EventsApiService {

    @GET("events/onetime/")
    suspend fun getEvents(
        @Query("page") page: Int?,
        @Query("title") title: String?,
    ): Response<EventModel>

//    @GET("home/tours/")
//    suspend fun getTours(
//        @Query("offset") offset: Int = 0,
//        @Query("limit") limit: Int,
//    ): Response<ShortTourResponse>

    @GET("events/onetime/{id}")
    suspend fun getEventById(
        @Path("id") id: Int,
    ): Response<EventModel>
}