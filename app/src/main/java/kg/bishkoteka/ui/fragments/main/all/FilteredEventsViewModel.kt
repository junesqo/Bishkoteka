package kg.bishkoteka.ui.fragments.main.all

import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.bishkoteka.core.base.BaseViewModel
import kg.bishkoteka.data.models.get.events.OnetimeEventResponse
import kg.bishkoteka.data.models.get.events.RegularEventResponse
import kg.bishkoteka.data.models.post.events.OnetimeEventFilter
import kg.bishkoteka.data.models.post.events.RegularEventFilter
import kg.bishkoteka.data.repositories.events.FilteredEventsRepository
import kg.bishkoteka.data.util.changeFilter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class FilteredEventsViewModel @Inject constructor(private val repository: FilteredEventsRepository
) : BaseViewModel() {

    private var onetimeEventFilter = OnetimeEventFilter()
    var getPagingOnetimeEvent = getOnetimeEvents()
    fun setOnetimeFilter(newOnetimeFilter: OnetimeEventFilter) = onetimeEventFilter.changeFilter(newOnetimeFilter)
    fun getOnetimeEvents(): Flow<PagingData<OnetimeEventResponse>> =
        repository.getFilteredEvents(onetimeEventFilter).gatherPagingRequest { it }


//    private var regularEventFilter = RegularEventFilter()
//    var getPagingRegularEvents = getRegularEvents()
//    fun setRegularFilter(newRegularFilter: RegularEventFilter) = regularEventFilter.changeFilter(newRegularFilter)
//    fun getRegularEvents(): Flow<PagingData<RegularEventResponse>> =
//        repository.getRegularEvents(regularEventFilter).gatherPagingRequest { it }
}