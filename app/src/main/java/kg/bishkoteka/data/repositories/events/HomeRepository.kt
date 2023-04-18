package kg.bishkoteka.data.repositories.events

import androidx.paging.PagingData
import kg.bishkoteka.data.base.BaseRepository
import kg.bishkoteka.data.remote.apiservice.events.PagingApiService
import kg.bishkoteka.data.models.get.events.OnetimeEventResponse
import kg.bishkoteka.data.models.get.events.RegularEventResponse
import kg.bishkoteka.data.models.post.events.OnetimeEventFilter
import kg.bishkoteka.data.models.post.events.RegularEventFilter
import kg.bishkoteka.data.remote.pagingSources.EventsPagingSource
import kg.bishkoteka.data.remote.pagingSources.RegularEventsPagingSource
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

    fun getOnetimeEvents(onetimeEventFilter: OnetimeEventFilter): Flow<PagingData<OnetimeEventResponse>> {
        return doPagingRequest(EventsPagingSource(apiService, onetimeEventFilter), pageSize = 10)
    }

    fun getRegularEvents(regularEventFilter: RegularEventFilter): Flow<PagingData<RegularEventResponse>> {
        return doPagingRequest(RegularEventsPagingSource(apiService, regularEventFilter), pageSize = 10)
    }

    fun getCategories() = doRequest { dataSource.getCategories() }

//    fun getTours(limit: Int) =
//        doRequest { dataSource.getEvents(limit = limit) }


}