package kg.bishkoteka.ui.fragments.main.home

import kg.bishkoteka.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.bishkoteka.data.remote.dto.events.CategoryModel
import kg.bishkoteka.data.remote.dto.events.EventsResponse
import kg.bishkoteka.data.repositories.events.HomeRepository
import kg.bishkoteka.ui.state.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository
) : BaseViewModel() {

    private val _getEventsState = MutableStateFlow<UIState<EventsResponse>>(UIState.Idle())
    val getEventsState = _getEventsState.asStateFlow()

    private val _getCategoriesState = MutableStateFlow<UIState<List<CategoryModel>>>(UIState.Idle())
    val getCategoriesState = _getCategoriesState.asStateFlow()

    fun getDefaultEvents() = homeRepository.getDefaultEvents("concerts").gatherPagingRequest { it }

    fun getCategories() = homeRepository.getCategories().collectFlow(_getCategoriesState)
//    fun getCategories() = homeRepository.getCategories().collectFlow(_getCategoriesState)

}

