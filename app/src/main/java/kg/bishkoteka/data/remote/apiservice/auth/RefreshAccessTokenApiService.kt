package kg.bishkoteka.data.remote.apiservice.auth

import kg.bishkoteka.data.remote.dto.auth.RefreshTokenDto
import kg.bishkoteka.data.remote.dto.auth.TokensDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RefreshAccessTokenApiService {

    @POST("accounts/login/refresh/")
    fun refreshTokens(@Body refreshToken: RefreshTokenDto): Call<TokensDto>
}