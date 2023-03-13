package kg.bishkoteka.ui.fragments.main.home

import kg.bishkoteka.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.bishkoteka.core.state.UIState
import kg.bishkoteka.data.remote.dto.events.EventsResponseDto
import kg.bishkoteka.data.repositories.EventsRepositoryImpl
import kg.bishkoteka.domain.usecases.FetchEventsUseCase
import kg.bishkoteka.ui.models.EventUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val fetchEventsUseCase: FetchEventsUseCase
) : BaseViewModel() {
    private val _events = mutableUiStateFlow<List<EventUi>>()
    val events = _events.asStateFlow()

//    fun fetchEvents(title: String) {
//        fetchEventsUseCase(title).gatherRequest(_events) { it.map { eventModel -> eventModel.toUI() } }
//    }

    fun fetchEvents(title: String) {
        fetchEventsUseCase(title).gatherPagingRequest {  }
    }

}

