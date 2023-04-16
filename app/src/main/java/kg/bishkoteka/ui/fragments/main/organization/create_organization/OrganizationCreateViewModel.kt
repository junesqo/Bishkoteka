package kg.bishkoteka.ui.fragments.main.organization.create_organization

import dagger.hilt.android.lifecycle.HiltViewModel
import kg.bishkoteka.core.base.BaseViewModel
import kg.bishkoteka.data.remote.dto.organization.CreateOrganizationDto
import kg.bishkoteka.data.repositories.organizations.OrganizationRepository
import kg.bishkoteka.ui.state.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class OrganizationCreateViewModel @Inject constructor(private val organizationRepository: OrganizationRepository
) : BaseViewModel() {

    private val _createOrganizationState = MutableStateFlow<UIState<Unit>>(UIState.Idle())
    val createOrganization = _createOrganizationState.asStateFlow()

    fun createOrganization(organization: CreateOrganizationDto) = organizationRepository.createOrganization(organization).collectFlow(_createOrganizationState)

}