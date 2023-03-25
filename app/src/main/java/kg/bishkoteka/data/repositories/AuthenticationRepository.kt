package kg.bishkoteka.data.repositories

import kg.bishkoteka.data.base.BaseRepository
import kg.bishkoteka.data.remote.apiservice.auth.AuthenticationApiService
import kg.bishkoteka.data.remote.dto.auth.SignInDto
import kg.bishkoteka.data.remote.dto.auth.SignUpDto
import javax.inject.Inject

class AuthenticationRepository @Inject constructor(
    private val authenticationApiService: AuthenticationApiService
) : BaseRepository() {


    fun signIn(username: String, password: String) = makeNetworkRequest {
        authenticationApiService.login(SignInDto(username, password))
    }

    fun signUp(
        first_name: String,
        last_name: String,
        username: String,
        date_of_birth: String,
        email: String,
        password: String,
        confirmPassword: String,
        interests_ids: List<Int>
    ) = makeNetworkRequest {
        authenticationApiService.signUp(
            SignUpDto(
                first_name,
                last_name,
                username,
                date_of_birth,
                email,
                password,
                confirmPassword,
                interests_ids
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