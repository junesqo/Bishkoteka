package kg.bishkoteka.data.repositories.events

import kg.bishkoteka.data.base.BaseRepository
import kg.bishkoteka.data.remote.apiservice.events.PagingApiService
import kg.bishkoteka.data.models.post.events.EventCreateRequest
import kg.bishkoteka.data.remote.remoteDataSource.RemoteDataSource
import okhttp3.RequestBody
import javax.inject.Inject

class CreateEventRepository @Inject constructor(
    private val dataSource: RemoteDataSource,
    private val apiService: PagingApiService,
) : BaseRepository() {

    fun createEvent(organizationId: Int, map: MutableMap<String, RequestBody>) = doRequest { dataSource.createEvent(organizationId, map) }


}