package kg.bishkoteka.data.repositories

import kg.bishkoteka.core.network.paging.makePagingRequest
import kg.bishkoteka.data.remote.apiservice.events.EventsApiService
import kg.bishkoteka.data.remote.pagingSources.EventsPagingSource
import kg.bishkoteka.domain.repositories.EventsRepository
import javax.inject.Inject

class EventsRepositoryImpl @Inject constructor(private val eventsApiService: EventsApiService) :
    EventsRepository {

    override fun fetchAllOneTimeEvents(
        title: String?
    ) = makePagingRequest (
        EventsPagingSource(eventsApiService, title)
    )

    //    override fun fetchAllOneTimeEvents() = doRequest {
//        dataSource.fetchAllOneTimeEvents()
//    }

    //    override fun fetchAllOneTimeEvents() = makeNetworkRequest {
//        eventsApiService.fetchAllOneTimeEvents().body()?.toDomain()
//    }

    //    override fun fetchAllOneTimeEvents(
//        title: String?,
//    ) = makeNetworkRequest(
//        eventsApiService, title
//    )
//    )




}

