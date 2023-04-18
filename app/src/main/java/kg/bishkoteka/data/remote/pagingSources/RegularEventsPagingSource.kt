package kg.bishkoteka.data.remote.pagingSources

import kg.bishkoteka.core.network.paging.BasePagingSource
import kg.bishkoteka.data.models.get.events.RegularEventResponse
import kg.bishkoteka.data.models.get.events.RegularEventsResponse
import kg.bishkoteka.data.models.post.events.RegularEventFilter
import kg.bishkoteka.data.remote.apiservice.events.PagingApiService

class RegularEventsPagingSource(
    private val pagingApiService: PagingApiService, filter: RegularEventFilter,
) :
    BasePagingSource<RegularEventsResponse, RegularEventResponse>({
        pagingApiService.getRegularEvents(
            it,
            categoryId = filter.category,
            searchQuery = filter.keyword
        )
    })