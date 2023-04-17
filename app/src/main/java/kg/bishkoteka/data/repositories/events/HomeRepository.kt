package kg.bishkoteka.data.repositories.events

import androidx.paging.PagingData
import kg.bishkoteka.data.base.BaseRepository
import kg.bishkoteka.data.remote.apiservice.events.PagingApiService
import kg.bishkoteka.data.models.get.events.EventResponse
import kg.bishkoteka.data.models.post.events.EventFilterModel
import kg.bishkoteka.data.remote.pagingSources.EventsPagingSource
import kg.bishkoteka.data.remote.remoteDataSource.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val dataSource: RemoteDataSource,
    private val apiService: PagingApiService,
) : BaseRepository() {

//    fun getDefaultEvents(): Flow<PagingData<EventModel>> {
//        return doPagingRequest(EventsPagingSource(apiService, FilterModel()))
//    }

    fun getNotFilteredEvents(eventFilterModel: EventFilterModel): Flow<PagingData<EventResponse>> {
        return doPagingRequest(EventsPagingSource(apiService, eventFilterModel), pageSize = 10)
    }

    fun getCategories() = doRequest { dataSource.getCategories() }

//    fun getTours(limit: Int) =
//        doRequest { dataSource.getEvents(limit = limit) }


}