package kg.bishkoteka.ui.fragments.authentication.signUp

import kg.bishkoteka.core.base.BaseViewModel
import kg.bishkoteka.data.repositories.AuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) : BaseViewModel() {

    private val _signUpState = mutableUiStateFlow<Unit>()
    val signUpState = _signUpState.asStateFlow()

    fun signUp(
        username: String,
        email: String,
        password: String,
        passwordConfirm: String,
    ) = authenticationRepository.signUp(
        username,
        email,
        password,
        passwordConfirm,
    ).gatherRequest(_signUpState)
}