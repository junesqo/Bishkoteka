package kg.bishkoteka.ui.fragments.authentication.signIn

import kg.bishkoteka.core.base.BaseViewModel
import kg.bishkoteka.repositories.AuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.bishkoteka.remote.dto.SignInResultDto
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) : BaseViewModel() {

    private val _signInState = mutableUiStateFlow<SignInResultDto>()
    val signInState = _signInState.asStateFlow()

    fun signIn(username: String, password: String) =
        authenticationRepository.signIn(username, password).gatherRequest(_signInState)
}