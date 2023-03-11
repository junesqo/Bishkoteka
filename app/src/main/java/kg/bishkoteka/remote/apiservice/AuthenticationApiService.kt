package kg.bishkoteka.remote.apiservice

import kg.bishkoteka.remote.dto.SignInDto
import kg.bishkoteka.remote.dto.SignInResultDto
import kg.bishkoteka.remote.dto.SignUpDto
import kg.bishkoteka.remote.dto.TokensDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApiService {

    @POST("accounts/signup/user/")
    suspend fun signUp(@Body signUpDto: SignUpDto)


    //TODO: ПОМЕНЯТЬ ЕНДПОИНТ
    @POST("token/")
    suspend fun login(@Body signInDto: SignInDto): SignInResultDto
}