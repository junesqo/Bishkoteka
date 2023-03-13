package kg.bishkoteka.domain.repositories

import androidx.paging.PagingData
import kg.bishkoteka.core.utils.Either
import kg.bishkoteka.domain.models.EventModel
import kg.bishkoteka.domain.models.EventsResponseModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface EventsRepository {

//    fun fetchAllOneTimeEvents(): Flow<Either<String, Response<EventsResponseModel>>>

    fun fetchAllOneTimeEvents(
        title: String?,
    ): Flow<PagingData<EventModel>>

}