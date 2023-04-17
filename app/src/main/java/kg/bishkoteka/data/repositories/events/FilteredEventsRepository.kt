package kg.bishkoteka.data.repositories.events

import androidx.paging.PagingData
import kg.bishkoteka.data.base.BaseRepository
import kg.bishkoteka.data.remote.apiservice.events.PagingApiService
import kg.bishkoteka.data.models.get.events.EventResponse
import kg.bishkoteka.data.models.post.events.EventFilterModel
import kg.bishkoteka.data.remote.pagingSources.EventsPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FilteredEventsRepository @Inject constructor(private val apiService: PagingApiService) :
    BaseRepository() {

    fun getFilteredEvents(filter: EventFilterModel): Flow<PagingData<EventResponse>> {
        return doPagingRequest(EventsPagingSource(apiService, filter), pageSize = 10)
    }
}