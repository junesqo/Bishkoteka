package kg.bishkoteka.ui.fragments.authentication.signIn

import kg.bishkoteka.core.base.BaseViewModel
import kg.bishkoteka.data.remote.dto.TokensDto
import kg.bishkoteka.data.repositories.AuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) : BaseViewModel() {

    private val _signInState = mutableUiStateFlow<TokensDto>()
    val signInState = _signInState.asStateFlow()

    fun signIn(email: String, password: String) =
        authenticationRepository.signIn(email, password).gatherRequest(_signInState)
}