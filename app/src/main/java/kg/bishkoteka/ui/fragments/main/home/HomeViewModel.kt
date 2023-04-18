package kg.bishkoteka.ui.fragments.main.home

import androidx.paging.PagingData
import kg.bishkoteka.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.bishkoteka.data.models.get.events.*
import kg.bishkoteka.data.models.post.events.OnetimeEventFilter
import kg.bishkoteka.data.models.post.events.RegularEventFilter
import kg.bishkoteka.data.repositories.events.HomeRepository
import kg.bishkoteka.ui.state.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : BaseViewModel() {

    private var onetimeEventFilter = OnetimeEventFilter()
    var getPagingOnetimeEvent = getOnetimeEvents()

    private val _getOnetimeEventsState =
        MutableStateFlow<UIState<OnetimeEventsResponse>>(UIState.Idle())
    val getOnetimeEventsState = _getOnetimeEventsState.asStateFlow()
    fun getOnetimeEvents(): Flow<PagingData<OnetimeEventResponse>> =
        homeRepository.getOnetimeEvents(onetimeEventFilter).gatherPagingRequest { it }


    private var regularEventFilter = RegularEventFilter()
    var getPagingRegularEvent = getRegularEvents()
    private val _getRegularEventsState =
        MutableStateFlow<UIState<RegularEventsResponse>>(UIState.Idle())
    val getRegularEventsState = _getRegularEventsState.asStateFlow()
    fun getRegularEvents(): Flow<PagingData<RegularEventResponse>> =
        homeRepository.getRegularEvents(regularEventFilter).gatherPagingRequest { it }


    private val _getCategoriesState =
        MutableStateFlow<UIState<List<CategoryResponse>>>(UIState.Idle())
    val getCategoriesState = _getCategoriesState.asStateFlow()
    fun getCategories() = homeRepository.getCategories().collectFlow(_getCategoriesState)

}

