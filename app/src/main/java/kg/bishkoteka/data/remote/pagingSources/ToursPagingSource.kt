package kg.bishkoteka.data.remote.pagingSources

import kg.bishkoteka.data.remote.dto.events.FilterModel
import kg.bishkoteka.core.network.paging.BasePagingSource
import kg.bishkoteka.data.remote.apiservice.events.PagingApiService

//class EventsPagingSource(private val apiService: PagingApiService, filter: FilterModel) :
//    BasePagingSource<EventsResponse, EventModel>({
//        apiService.getFilteredEvents(
//            it,
//            category = filter.category,
//            date_departure = filter.date_departure,
//            complexity = filter.complexity,
//            duration = filter.duration,
//            price_max = filter.price_max,
//        )
//    }
//    )