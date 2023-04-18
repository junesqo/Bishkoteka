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
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FilteredEventsRepository @Inject constructor(private val apiService: PagingApiService) :
    BaseRepository() {

    fun getFilteredEvents(filter: OnetimeEventFilter): Flow<PagingData<OnetimeEventResponse>> {
        return doPagingRequest(EventsPagingSource(apiService, filter), pageSize = 10)
    }

//    fun getRegularEvents(filter: RegularEventFilter): Flow<PagingData<RegularEventResponse>> {
//        return doPagingRequest(RegularEventsPagingSource(apiService, filter), pageSize = 10)
//    }
}