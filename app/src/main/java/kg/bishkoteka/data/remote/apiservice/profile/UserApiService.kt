package kg.bishkoteka.data.remote.apiservice.profile

import kg.bishkoteka.data.models.post.organization.OrganizationCreateRequest
import kg.bishkoteka.data.models.get.organization.OrganizationResponse
import kg.bishkoteka.data.models.get.profile.UserResponse
import kg.bishkoteka.data.models.post.profile.ProfileEditRequest
import retrofit2.Response
import retrofit2.http.*

interface UserApiService {

    @GET("profile/customer/{id}/")
    suspend fun getUserProfile(@Path("id") id: Int): Response<UserResponse>

    @PUT("profile/customer/{id}/")
    suspend fun editProfile(
        @Path("id") id: Int,
        @Body profileEditRequest: ProfileEditRequest
    ): Response<Unit>

    @GET("profile/customer/{id}/organizations/")
    suspend fun getMyOrganizations(
        @Path("id") id: Int
    ): Response<List<OrganizationResponse>>

    @GET("profile/organization/{id}/")
    suspend fun getOrganizationById(
        @Path("id") id: Int,
    ): Response<OrganizationResponse>

    @POST("users/create/organization/")
    suspend fun createOrganization(@Body organizationCreateRequest: OrganizationCreateRequest): Response<Unit>

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

//    @POST("events/{id}/favorite/")
//    suspend fun addFavorite(@Path("id") id: Int): Response<Unit>
//
//    @DELETE("events/{id}/favorite/")
//    suspend fun deleteFavorite(@Path("id") id: Int): Response<Unit>
}