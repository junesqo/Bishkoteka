package kg.bishkoteka.ui.fragments.main.organization.organization_details

import dagger.hilt.android.lifecycle.HiltViewModel
import kg.bishkoteka.core.base.BaseViewModel
import kg.bishkoteka.data.remote.dto.events.EventModel
import kg.bishkoteka.data.remote.dto.organization.OrganizationDto
import kg.bishkoteka.data.repositories.organizations.OrganizationRepository
import kg.bishkoteka.ui.state.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class OrganizationDetailsViewModel @Inject constructor(private val organizationRepository: OrganizationRepository
) : BaseViewModel() {

    private val _getMyOrganizationByIdState = MutableStateFlow<UIState<OrganizationDto>>(UIState.Idle())
    val getMyOrganizationByIdState = _getMyOrganizationByIdState.asStateFlow()

    fun getMyOrganizationById(organizationId: Int) = organizationRepository.getMyOrganizationById(organizationId).collectFlow(_getMyOrganizationByIdState)

}