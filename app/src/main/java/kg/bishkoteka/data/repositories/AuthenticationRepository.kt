package kg.bishkoteka.data.repositories

import kg.bishkoteka.core.network.paging.BaseRepository
import kg.bishkoteka.data.remote.apiservice.auth.AuthenticationApiService
import kg.bishkoteka.data.remote.dto.auth.SignInDto
import kg.bishkoteka.data.remote.dto.auth.SignUpDto
import javax.inject.Inject

class AuthenticationRepository @Inject constructor(
    private val authenticationApiService: AuthenticationApiService
) : BaseRepository() {

    fun signUp(
        first_name: String,
        last_name: String,
        username: String,
        email: String,
        password: String,
        confirmPassword: String
    ) = makeNetworkRequest {
        authenticationApiService.signUp(
            SignUpDto(
                first_name,
                last_name,
                username,
                email,
                password,
                confirmPassword
            )
        )
    }

    fun signIn(username: String, password: String) = makeNetworkRequest {
        authenticationApiService.login(SignInDto(username, password))
    }
}