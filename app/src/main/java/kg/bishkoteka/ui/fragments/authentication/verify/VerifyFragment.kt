package kg.bishkoteka.ui.fragments.authentication.verify

import dagger.hilt.android.lifecycle.HiltViewModel
import kg.bishkoteka.core.base.BaseViewModel
import kg.bishkoteka.remote.dto.TokensDto
import kg.bishkoteka.repositories.AuthenticationRepository
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class VerifyFragment @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) : BaseViewModel() {
//
//    private val _verifyState = mutableUiStateFlow<Unit>()
//    val verifyState = _verifyState.asStateFlow()
//
//    fun verify(email: String) =
//        authenticationRepository.signIn(email).gatherRequest(_verifyState)
}