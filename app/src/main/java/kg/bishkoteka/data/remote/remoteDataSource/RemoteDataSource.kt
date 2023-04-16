package kg.bishkoteka.data.remote.remoteDataSource

import kg.bishkoteka.core.network.baseDataSource.BaseDataSource
import kg.bishkoteka.data.remote.apiservice.events.EventsApiService
import kg.bishkoteka.data.remote.apiservice.profile.UserApiService
import kg.bishkoteka.data.remote.dto.events.CreateEventDto
import kg.bishkoteka.data.remote.dto.organization.CreateOrganizationDto
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val eventsApiService: EventsApiService,
    private val userApiService: UserApiService
) : BaseDataSource() {

//    suspend fun getCategoryEvents(categoryId: Int) = getResult { apiService.getEvents(categoryId = categoryId) }
    suspend fun createEvent(organizationId: Int, eventDto: CreateEventDto) = getResult { eventsApiService.createEvent(organizationId, eventDto) }
    suspend fun getEventById(eventId: Int) = getResult { eventsApiService.getEventById(eventId) }
    suspend fun getCategories() = getResult { eventsApiService.getCategories() }
    suspend fun createOrganization(createOrganizationDto: CreateOrganizationDto) = getResult { userApiService.createOrganization(createOrganizationDto) }
    suspend fun getMyOrganizations(userId: Int) = getResult { userApiService.getMyOrganizations(userId) }

    suspend fun getOrganizationById(organizationId: Int) = getResult { userApiService.getOrganizationById(organizationId) }
}