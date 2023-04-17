package kg.bishkoteka.data.remote.apiservice.auth

import kg.bishkoteka.data.models.post.auth.SignInRequest
import kg.bishkoteka.data.models.get.auth.SignInResultResponse
import kg.bishkoteka.data.models.post.auth.SignUpRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApiService {

    @POST("users/signup/customer/")
    suspend fun signUp(@Body signUpRequest: SignUpRequest)

    @POST("users/login/")
    suspend fun login(@Body signInRequest: SignInRequest): SignInResultResponse
}