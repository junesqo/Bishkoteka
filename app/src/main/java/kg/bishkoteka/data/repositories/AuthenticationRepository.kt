package kg.bishkoteka.data.repositories

import kg.bishkoteka.data.base.BaseRepository
import kg.bishkoteka.data.remote.apiservice.auth.AuthenticationApiService
import kg.bishkoteka.data.models.post.auth.SignInRequest
import kg.bishkoteka.data.models.post.auth.SignUpRequest
import javax.inject.Inject

class AuthenticationRepository @Inject constructor(
    private val authenticationApiService: AuthenticationApiService
) : BaseRepository() {


    fun signIn(username: String, password: String) = makeNetworkRequest {
        authenticationApiService.login(SignInRequest(username, password))
    }

    fun signUp(
        username: String,
        email: String,
        password: String,
        confirmPassword: String,
    ) = makeNetworkRequest {
        authenticationApiService.signUp(
            SignUpRequest(
                username,
                email,
                password,
                confirmPassword,
            )
        )
    }

//    fun signUpOrganization(
//        name: String,
//        description: String,
//        type: String,
//        insta_link: String,
//        phone_number: String,
//        email: String,
//        password: String,
//        confirmPassword: String
//    ) = makeNetworkRequest {
//        authenticationApiService.signUpOrganization(
//            SignUpOrganizationDto(
//                name, description, type, insta_link, phone_number, email, password, confirmPassword
//            )
//        )
//    }


}