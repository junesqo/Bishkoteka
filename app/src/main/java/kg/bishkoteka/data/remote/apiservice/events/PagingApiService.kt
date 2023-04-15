package kg.bishkoteka.data.remote.apiservice.events

import kg.bishkoteka.data.remote.dto.events.EventsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PagingApiService {

    @GET("events/onetime/")
    suspend fun getFilteredEvents(
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 1,
        @Query("keyword") searchQuery: String,
        @Query("category") categoryId: String,
        @Query("start_time") startTime: String
    ): Response<EventsResponse>

}