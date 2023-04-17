package kg.bishkoteka.ui.fragments.main.event.event_details

import dagger.hilt.android.lifecycle.HiltViewModel
import kg.bishkoteka.core.base.BaseViewModel
import kg.bishkoteka.data.models.get.events.EventResponse
import kg.bishkoteka.data.repositories.events.DetailEventRepository
import kg.bishkoteka.ui.state.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class EventDetailsViewModel @Inject constructor(
    private val detailEventRepository: DetailEventRepository
) : BaseViewModel() {

    private val _getEventByIdState = MutableStateFlow<UIState<EventResponse>>(UIState.Idle())
    val getEventByIdState = _getEventByIdState.asStateFlow()

    fun getEventById(eventId: Int) = detailEventRepository.getEventById(eventId).collectFlow(_getEventByIdState)

}