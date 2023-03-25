package kg.bishkoteka.data.remote.remoteDataSource

import kg.bishkoteka.core.network.baseDataSource.BaseDataSource
import kg.bishkoteka.data.remote.apiservice.events.EventsApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService : EventsApiService) : BaseDataSource(){

//    suspend fun getCategoryEvents(categoryId: Int) = getResult { apiService.getEvents(categoryId = categoryId) }

    suspend fun getCategories() = getResult { apiService.getCategories() }

}