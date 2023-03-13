package kg.bishkoteka.data.remote.remoteDataSource

import kg.bishkoteka.core.network.baseDataSource.BaseDataSource
import kg.bishkoteka.data.remote.apiservice.events.EventsApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService : EventsApiService) : BaseDataSource(){

    suspend fun fetchAllOneTimeEvents() = getResult { apiService.fetchAllOneTimeEvents() }

//    suspend fun getSlugs() = getResult { apiService.getSlugs() }

//    suspend fun getTourModelBySlug(slug: String) = getResult { apiService.getTourBySlug(slug) }

}