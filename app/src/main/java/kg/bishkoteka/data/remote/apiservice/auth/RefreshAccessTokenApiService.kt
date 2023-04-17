package kg.bishkoteka.data.remote.apiservice.auth

import kg.bishkoteka.data.models.get.auth.RefreshTokenResponse
import kg.bishkoteka.data.models.get.auth.TokensResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RefreshAccessTokenApiService {

    @POST("users/login/refresh/")
    fun refreshTokens(@Body refreshToken: RefreshTokenResponse): Call<TokensResponse>
}