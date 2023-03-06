package kg.bishkoteka.data.remote.apiservice

import kg.bishkoteka.data.remote.dto.SignInDto
import kg.bishkoteka.data.remote.dto.SignUpDto
import kg.bishkoteka.data.remote.dto.TokensDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApiService {

    @POST("accounts/signup/user/")
    suspend fun signUp(@Body signUpDto: SignUpDto)

    @POST("users/login/")
    suspend fun login(@Body signInDto: SignInDto): TokensDto
}