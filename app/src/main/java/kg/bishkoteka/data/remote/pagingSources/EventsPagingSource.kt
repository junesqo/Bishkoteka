package kg.bishkoteka.data.remote.pagingSources

import kg.bishkoteka.core.network.paging.BasePagingSource
import kg.bishkoteka.data.remote.apiservice.events.PagingApiService
import kg.bishkoteka.data.models.get.events.EventResponse
import kg.bishkoteka.data.models.get.events.EventsResponse
import kg.bishkoteka.data.models.post.events.EventFilterModel

class EventsPagingSource(
    private val pagingApiService: PagingApiService, filter: EventFilterModel,
) :
    BasePagingSource<EventsResponse, EventResponse>({
        pagingApiService.getFilteredEvents(it,
            categoryId = filter.category,
            searchQuery = filter.keyword,
            startTime = filter.starttime
        )
    })