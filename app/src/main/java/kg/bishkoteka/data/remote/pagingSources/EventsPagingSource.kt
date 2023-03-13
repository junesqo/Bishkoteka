package kg.bishkoteka.data.remote.pagingSources

import kg.bishkoteka.core.network.paging.BasePagingSource
import kg.bishkoteka.data.remote.apiservice.events.EventsApiService
import kg.bishkoteka.data.remote.dto.events.EventDto
import kg.bishkoteka.domain.models.EventModel

class EventsPagingSource(
    private val eventsApiService: EventsApiService,
    private val title: String?,
) :
    BasePagingSource<EventDto, EventModel>({
        eventsApiService.fetchAllOneTimeEvents(it, title)
    })