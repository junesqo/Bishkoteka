package kg.bishkoteka.data.remote.apiservice.user

import kg.bishkoteka.data.remote.dto.user.UserDto
import retrofit2.Response
import retrofit2.http.*

interface UserApiService {

    @GET("profiles/profile/{id}/")
    suspend fun getUserProfile(@Path("id") id: Int): UserDto

//    @GET("profiles/{id}/favorites")
//    suspend fun fetchFavorites(@Path("id") id: Int): FavoriteTourResponse

//    @DELETE("accounts/profile/customer/{id}/")
//    suspend fun deleteAccount(@Path("id") id: Int)
//
//    @DELETE("accounts/profile/organization/{id}/")
//    suspend fun deleteOrganization(@Path("id") id: Int)

//    @POST("home/review/")
//    suspend fun addReview(@Body addCommentModel: AddCommentModel): Response<Unit>

//    @PATCH("profiles/change-password/{id}/")
//    suspend fun changePassword(@Path("id") id: Int, @Body changePasswordDto: ChangePasswordDto)

//    @PUT("profiles/profile/{id}/")
//    suspend fun changeUsernameOrEmail(@Body changeUsernameOrEmailDto: ChangeUsernameOrEmailDto)

    @POST("events/{id}/favorite/")
    suspend fun addFavorite(@Path("id") id: Int): Response<Unit>

    @DELETE("events/{id}/favorite/")
    suspend fun deleteFavorite(@Path("id") id: Int): Response<Unit>
}