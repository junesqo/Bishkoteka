package kg.bishkoteka.ui.fragments.main.home

import androidx.paging.PagingData
import kg.bishkoteka.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.bishkoteka.data.models.get.events.CategoryResponse
import kg.bishkoteka.data.models.get.events.EventResponse
import kg.bishkoteka.data.models.get.events.EventsResponse
import kg.bishkoteka.data.models.post.events.EventFilterModel
import kg.bishkoteka.data.repositories.events.HomeRepository
import kg.bishkoteka.ui.state.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository
) : BaseViewModel() {

    private var filter = EventFilterModel()
    var getPagingEvent = getNotFilteredEvents()

    private val _getEventsState = MutableStateFlow<UIState<EventsResponse>>(UIState.Idle())
    val getEventsState = _getEventsState.asStateFlow()

    private val _getCategoriesState = MutableStateFlow<UIState<List<CategoryResponse>>>(UIState.Idle())
    val getCategoriesState = _getCategoriesState.asStateFlow()

//    fun getDefaultEvents() = homeRepository.getDefaultEvents().gatherPagingRequest { it }

    fun getNotFilteredEvents(): Flow<PagingData<EventResponse>> =
        homeRepository.getNotFilteredEvents(filter).gatherPagingRequest { it }

    fun getCategories() = homeRepository.getCategories().collectFlow(_getCategoriesState)
//    fun getCategories() = homeRepository.getCategories().collectFlow(_getCategoriesState)

}

