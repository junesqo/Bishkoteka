package kg.bishkoteka.data.remote.apiservice.auth

import kg.bishkoteka.data.remote.dto.auth.SignInDto
import kg.bishkoteka.data.remote.dto.auth.SignInResultDto
import kg.bishkoteka.data.remote.dto.auth.SignUpDto
import kg.bishkoteka.data.remote.dto.organization.OrganizationDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApiService {

    @POST("users/signup/customer/")
    suspend fun signUp(@Body signUpDto: SignUpDto)



    @POST("users/login/")
    suspend fun login(@Body signInDto: SignInDto): SignInResultDto
}