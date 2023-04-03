package kg.bishkoteka.data.repositories.events

import androidx.paging.PagingData
import kg.bishkoteka.data.base.BaseRepository
import kg.bishkoteka.data.remote.apiservice.events.PagingApiService
import kg.bishkoteka.data.remote.dto.events.EventModel
import kg.bishkoteka.data.remote.dto.events.FilterModel
import kg.bishkoteka.data.remote.pagingSources.EventsPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FilteredEventsRepository @Inject constructor(private val apiService: PagingApiService) :
    BaseRepository() {

    fun getFilteredEvents(filter: FilterModel): Flow<PagingData<EventModel>> {
        return doPagingRequest(EventsPagingSource(apiService, filter), pageSize = 10)
    }
}