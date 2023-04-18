package kg.bishkoteka.data.remote.pagingSources

import kg.bishkoteka.core.network.paging.BasePagingSource
import kg.bishkoteka.data.remote.apiservice.events.PagingApiService
import kg.bishkoteka.data.models.get.events.OnetimeEventResponse
import kg.bishkoteka.data.models.get.events.OnetimeEventsResponse
import kg.bishkoteka.data.models.post.events.OnetimeEventFilter

class EventsPagingSource(
    private val pagingApiService: PagingApiService, filter: OnetimeEventFilter,
) :
    BasePagingSource<OnetimeEventsResponse, OnetimeEventResponse>({
        pagingApiService.getFilteredEvents(it,
            categoryId = filter.category,
            searchQuery = filter.keyword,
            startTime = filter.starttime
        )
    })

