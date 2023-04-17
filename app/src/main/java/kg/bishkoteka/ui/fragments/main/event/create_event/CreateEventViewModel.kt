package kg.bishkoteka.ui.fragments.main.event.create_event

import dagger.hilt.android.lifecycle.HiltViewModel
import kg.bishkoteka.core.base.BaseViewModel
import kg.bishkoteka.data.models.post.events.EventCreateRequest
import kg.bishkoteka.data.repositories.events.CreateEventRepository
import kg.bishkoteka.ui.state.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CreateEventViewModel @Inject constructor(private val createEventRepository: CreateEventRepository
) : BaseViewModel() {

    private val _createEventState = MutableStateFlow<UIState<Unit>>(UIState.Idle())
    val createEvent = _createEventState.asStateFlow()

    fun createEvent(organizationId: Int, eventCreateRequest: EventCreateRequest) = createEventRepository.createEvent(organizationId, eventCreateRequest).collectFlow(_createEventState)

}