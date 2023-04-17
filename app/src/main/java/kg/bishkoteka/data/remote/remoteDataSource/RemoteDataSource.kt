package kg.bishkoteka.data.remote.remoteDataSource

import kg.bishkoteka.core.network.baseDataSource.BaseDataSource
import kg.bishkoteka.data.remote.apiservice.events.EventsApiService
import kg.bishkoteka.data.remote.apiservice.profile.UserApiService
import kg.bishkoteka.data.models.post.events.EventCreateRequest
import kg.bishkoteka.data.models.post.organization.OrganizationCreateRequest
import kg.bishkoteka.data.models.post.profile.ProfileEditRequest
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val eventsApiService: EventsApiService,
    private val userApiService: UserApiService
) : BaseDataSource() {

//    suspend fun getCategoryEvents(categoryId: Int) = getResult { apiService.getEvents(categoryId = categoryId) }
    suspend fun createEvent(organizationId: Int, eventDto: EventCreateRequest) = getResult { eventsApiService.createEvent(organizationId, eventDto) }
    suspend fun getEventById(eventId: Int) = getResult { eventsApiService.getEventById(eventId) }
    suspend fun getCategories() = getResult { eventsApiService.getCategories() }
    suspend fun createOrganization(organizationCreateRequest: OrganizationCreateRequest) = getResult { userApiService.createOrganization(organizationCreateRequest) }
    suspend fun getMyOrganizations(userId: Int) = getResult { userApiService.getMyOrganizations(userId) }
    suspend fun getOrganizationById(organizationId: Int) = getResult { userApiService.getOrganizationById(organizationId) }
    suspend fun getMyProfile(userId: Int) = getResult { userApiService.getUserProfile(userId) }

    suspend fun editProfile(userId: Int, profileEditRequest: ProfileEditRequest) = getResult { userApiService.editProfile(userId, profileEditRequest) }
}