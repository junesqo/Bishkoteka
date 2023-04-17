package kg.bishkoteka.ui.fragments.main.profile

import kg.bishkoteka.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.bishkoteka.data.models.get.profile.UserResponse
import kg.bishkoteka.data.models.post.organization.OrganizationCreateRequest
import kg.bishkoteka.data.models.post.profile.ProfileEditRequest
import kg.bishkoteka.data.repositories.profile.ProfileRepository
import kg.bishkoteka.ui.state.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val profileRepository: ProfileRepository
) : BaseViewModel() {

    private val _editProfileState = MutableStateFlow<UIState<Unit>>(UIState.Idle())
    val editProfile = _editProfileState.asStateFlow()
    fun editProfile(profileEditRequest: ProfileEditRequest) = profileRepository.editProfile(profileEditRequest).collectFlow(_editProfileState)


    private val _getMyProfileState = MutableStateFlow<UIState<UserResponse>>(UIState.Idle())
    val getMyProfileState = _getMyProfileState.asStateFlow()
    fun getMyProfile() = profileRepository.getMyProfile().collectFlow(_getMyProfileState)
}
