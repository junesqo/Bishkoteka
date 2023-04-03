package kg.bishkoteka.ui.fragments.main.all

import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.bishkoteka.core.base.BaseViewModel
import kg.bishkoteka.data.remote.dto.events.EventModel
import kg.bishkoteka.data.remote.dto.events.FilterModel
import kg.bishkoteka.data.repositories.events.FilteredEventsRepository
import kg.bishkoteka.data.util.changeFilter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class FilteredEventsViewModel @Inject constructor(private val repository: FilteredEventsRepository
) : BaseViewModel() {

    private var filter = FilterModel()
    var getPagingEvent = getFilteredEvents()

    fun setFilter(newFilter: FilterModel) = filter.changeFilter(newFilter)

    fun getFilteredEvents(): Flow<PagingData<EventModel>> =
        repository.getFilteredEvents(filter).gatherPagingRequest { it }
}