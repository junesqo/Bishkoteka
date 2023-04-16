package kg.bishkoteka.ui.fragments.main.organization.my_organizations

import dagger.hilt.android.lifecycle.HiltViewModel
import kg.bishkoteka.core.base.BaseViewModel
import kg.bishkoteka.data.remote.dto.events.CategoryModel
import kg.bishkoteka.data.remote.dto.organization.OrganizationDto
import kg.bishkoteka.data.repositories.organizations.OrganizationRepository
import kg.bishkoteka.ui.state.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MyOrganizationsViewModel @Inject constructor(private val organizationRepository: OrganizationRepository
) : BaseViewModel() {

    private val _getMyOrganizationsState = MutableStateFlow<UIState<List<OrganizationDto>>>(UIState.Idle())
    val getMyOrganizationsState = _getMyOrganizationsState.asStateFlow()

    fun getMyOrganizations() = organizationRepository.getMyOrganizations().collectFlow(_getMyOrganizationsState)

}