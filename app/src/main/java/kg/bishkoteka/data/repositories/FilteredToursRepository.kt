package kg.bishkoteka.data.repositories

import androidx.paging.PagingData
import kg.bishkoteka.data.remote.dto.events.FilterModel
import kg.bishkoteka.data.remote.dto.events.TourModel
//import kg.bishkoteka.data.remote.pagingSources.ToursPagingSource
import kg.bishkoteka.core.network.paging.BaseRepository
import kg.bishkoteka.data.remote.apiservice.events.PagingApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FilteredToursRepository @Inject constructor(private val apiService: PagingApiService) :
    BaseRepository() {

//    fun getFilteredTours(filter: FilterModel): Flow<PagingData<TourModel>> {
//        return doPagingRequest(ToursPagingSource(apiService, filter), pageSize = 10)
//    }
}