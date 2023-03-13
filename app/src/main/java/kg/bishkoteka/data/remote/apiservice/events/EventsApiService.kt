package kg.bishkoteka.data.remote.apiservice.events

import kg.bishkoteka.core.network.paging.BasePagingResponse
import kg.bishkoteka.core.network.paging.BasePagingSource
import kg.bishkoteka.data.remote.dto.events.EventDto
import kg.bishkoteka.data.remote.dto.events.EventsResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EventsApiService {

    @GET("events/onetime/")
    suspend fun fetchAllOneTimeEvents(
        @Query("page") page: Int?,
        @Query("title") title: String?,
    ): BasePagingResponse<EventDto>
}