package kg.bishkoteka.ui.fragments.main.event.event_details

import dagger.hilt.android.lifecycle.HiltViewModel
import kg.bishkoteka.core.base.BaseViewModel
import kg.bishkoteka.data.models.get.events.OnetimeEventResponse
import kg.bishkoteka.data.models.post.events.CommentRequest
import kg.bishkoteka.data.repositories.events.DetailEventRepository
import kg.bishkoteka.ui.state.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class EventDetailsViewModel @Inject constructor(
    private val detailEventRepository: DetailEventRepository
) : BaseViewModel() {

    private val _getEventByIdState = MutableStateFlow<UIState<OnetimeEventResponse>>(UIState.Idle())
    val getEventByIdState = _getEventByIdState.asStateFlow()

    fun getEventById(eventId: Int) = detailEventRepository.getEventById(eventId).collectFlow(_getEventByIdState)

    private val _addCommentState = MutableStateFlow<UIState<Unit>>(UIState.Idle())
    val addComment = _addCommentState.asStateFlow()

    fun addComment(eventId: Int, commentRequest: CommentRequest) = detailEventRepository.addComment(eventId, commentRequest).collectFlow(_addCommentState)


}