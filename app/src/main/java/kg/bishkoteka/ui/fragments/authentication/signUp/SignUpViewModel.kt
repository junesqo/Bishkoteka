package kg.bishkoteka.ui.fragments.authentication.signUp

import kg.bishkoteka.core.base.BaseViewModel
import kg.bishkoteka.repositories.AuthenticationRepository
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
        name: String,
        lastname: String,
        username: String,
        email: String,
        birthdate: String,
        password: String,
        passwordConfirm: String
    ) = authenticationRepository.signUp(
        name,
        lastname,
        username,
        email,
        birthdate,
        password,
        passwordConfirm
    ).gatherRequest(_signUpState)
}