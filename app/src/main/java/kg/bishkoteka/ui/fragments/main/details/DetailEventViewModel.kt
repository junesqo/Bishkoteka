package kg.bishkoteka.ui.fragments.main.details

import dagger.hilt.android.lifecycle.HiltViewModel
import kg.bishkoteka.core.base.BaseViewModel
import kg.bishkoteka.data.remote.dto.events.EventModel
import kg.bishkoteka.data.repositories.events.DetailEventRepository
import kg.bishkoteka.ui.state.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailEventViewModel @Inject constructor(
    private val detailEventRepository: DetailEventRepository
) : BaseViewModel() {

    private val _getEventByIdState = MutableStateFlow<UIState<EventModel>>(UIState.Idle())
    val getEventByIdState = _getEventByIdState.asStateFlow()

    fun getEventById(eventId: Int) = detailEventRepository.getEventById(eventId).collectFlow(_getEventByIdState)

}