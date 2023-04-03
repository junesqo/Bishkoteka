package kg.bishkoteka.data.remote.apiservice.auth

import kg.bishkoteka.data.remote.dto.auth.SignInDto
import kg.bishkoteka.data.remote.dto.auth.SignInResultDto
import kg.bishkoteka.data.remote.dto.auth.SignUpDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApiService {

    @POST("accounts/signup/customer/")
    suspend fun signUp(@Body signUpDto: SignUpDto)

//    @POST("accounts/signup/organization")
//    suspend fun signUpOrganization(@Body signUpOrgDto: SignUpOrganizationDto)

    @POST("accounts/login/")
    suspend fun login(@Body signInDto: SignInDto): SignInResultDto
}