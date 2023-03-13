package kg.bishkoteka.data.repositories

import kg.bishkoteka.core.network.paging.BaseRepository
import kg.bishkoteka.data.remote.remoteDataSource.RemoteDataSource
import javax.inject.Inject

class SearchRepository @Inject constructor(private val dataSource: RemoteDataSource) : BaseRepository() {

    fun fetchAllOneTimeEvents() = doRequest {
        dataSource.fetchAllOneTimeEvents()
    }
}