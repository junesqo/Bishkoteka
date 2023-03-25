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
        first_name: String,
        last_name: String,
        username: String,
        date_of_birth: String,
        email: String,
        password: String,
        passwordConfirm: String,
        interests_ids: List<Int>
    ) = authenticationRepository.signUp(
        first_name,
        last_name,
        username,
        date_of_birth,
        email,
        password,
        passwordConfirm,
        interests_ids
    ).gatherRequest(_signUpState)
}