package kg.bishkoteka.data.repositories.events

import androidx.paging.PagingData
import kg.bishkoteka.data.base.BaseRepository
import kg.bishkoteka.data.remote.apiservice.events.PagingApiService
import kg.bishkoteka.data.remote.dto.events.EventModel
import kg.bishkoteka.data.remote.dto.events.FilterModel
import kg.bishkoteka.data.remote.pagingSources.EventsPagingSource
import kg.bishkoteka.data.remote.remoteDataSource.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val dataSource: RemoteDataSource,
    private val apiService: PagingApiService,
) : BaseRepository() {

    fun getDefaultEvents(category: String): Flow<PagingData<EventModel>> {
        return doPagingRequest(EventsPagingSource(apiService, FilterModel(category)), pageSize = 5)
    }

    fun getCategories() = doRequest { dataSource.getCategories() }

//    fun getTours(limit: Int) =
//        doRequest { dataSource.getEvents(limit = limit) }


}