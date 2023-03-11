package kg.bishkoteka.repositories

import kg.bishkoteka.data.base.BaseRepository
import kg.bishkoteka.remote.apiservice.AuthenticationApiService
import kg.bishkoteka.remote.dto.SignInDto
import kg.bishkoteka.remote.dto.SignUpDto
import javax.inject.Inject

class AuthenticationRepository @Inject constructor(
    private val authenticationApiService: AuthenticationApiService
) : BaseRepository() {

    fun signUp(
        name: String,
        lastname: String,
        username: String,
        email: String,
        birthdate: String,
        password: String,
        confirmPassword: String
    ) = makeNetworkRequest {
        authenticationApiService.signUp(
            SignUpDto(
                name,
                lastname,
                username,
                email,
                birthdate,
                password,
                confirmPassword
            )
        )
    }

    fun signIn(username: String, password: String) = makeNetworkRequest {
        authenticationApiService.login(SignInDto(username, password))
    }
}