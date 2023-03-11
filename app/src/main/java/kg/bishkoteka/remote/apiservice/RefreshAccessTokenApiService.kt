package kg.bishkoteka.remote.apiservice

import kg.bishkoteka.remote.dto.RefreshTokenDto
import kg.bishkoteka.remote.dto.TokensDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RefreshAccessTokenApiService {

    @POST("token/refresh/")
    fun refreshTokens(@Body refreshToken: RefreshTokenDto): Call<TokensDto>
}