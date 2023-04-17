package kg.bishkoteka.data.repositories.profile

import kg.bishkoteka.data.base.BaseRepository
import kg.bishkoteka.data.local.preferences.UserPreferences
import kg.bishkoteka.data.models.post.profile.ProfileEditRequest
import kg.bishkoteka.data.remote.apiservice.events.PagingApiService
import kg.bishkoteka.data.remote.remoteDataSource.RemoteDataSource
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val dataSource: RemoteDataSource,
    private val apiService: PagingApiService,
    private val userPreferences: UserPreferences
) : BaseRepository() {

    fun getMyProfile() = doRequest { dataSource.getMyProfile(userPreferences.userID.toString().toInt()) }
    fun editProfile(profileEditRequest: ProfileEditRequest) = doRequest { dataSource.editProfile(userPreferences.userID.toString().toInt(), profileEditRequest) }

}