package kg.bishkoteka.data.remote.pagingSources

import kg.bishkoteka.core.network.paging.BasePagingSource
import kg.bishkoteka.data.remote.apiservice.events.EventsApiService
import kg.bishkoteka.data.remote.apiservice.events.PagingApiService
import kg.bishkoteka.data.remote.dto.events.EventModel
import kg.bishkoteka.data.remote.dto.events.EventsResponse
import kg.bishkoteka.data.remote.dto.events.FilterModel

class EventsPagingSource(
    private val pagingApiService: PagingApiService, filter: FilterModel,
) :
    BasePagingSource<EventsResponse, EventModel>({
        pagingApiService.getFilteredEvents(it,
        searchQuery = filter.query,
        categoryId = filter.category)
    })