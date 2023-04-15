package kg.bishkoteka.data.repositories.events

import kg.bishkoteka.data.base.BaseRepository
import kg.bishkoteka.data.remote.apiservice.events.PagingApiService
import kg.bishkoteka.data.remote.remoteDataSource.RemoteDataSource
import javax.inject.Inject

class DetailEventRepository @Inject constructor(
    private val dataSource: RemoteDataSource,
    private val apiService: PagingApiService,
) : BaseRepository() {

    fun getEventById(eventId: Int) = doRequest { dataSource.getEventById(eventId) }
}