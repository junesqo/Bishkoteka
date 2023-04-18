package kg.bishkoteka.data.models.get.events

import kg.bishkoteka.core.network.paging.DataMapper

data class RegularEventsResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<RegularEventResponse>,
) : DataMapper<RegularEventResponse> {
    override fun responseToModel(): List<RegularEventResponse> = this.results
}
