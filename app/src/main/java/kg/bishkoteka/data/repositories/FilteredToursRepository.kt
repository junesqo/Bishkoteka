package kg.bishkoteka.data.repositories

//import kg.bishkoteka.data.remote.pagingSources.ToursPagingSource
import kg.bishkoteka.core.network.paging.BaseRepository
import javax.inject.Inject

class FilteredToursRepository @Inject constructor(private val apiService: PagingApiService) :
    BaseRepository() {

//    fun getFilteredTours(filter: FilterModel): Flow<PagingData<TourModel>> {
//        return doPagingRequest(ToursPagingSource(apiService, filter), pageSize = 10)
//    }
}