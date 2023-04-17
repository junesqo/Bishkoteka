package kg.bishkoteka.data.repositories.organizations

import kg.bishkoteka.data.base.BaseRepository
import kg.bishkoteka.data.local.preferences.UserPreferences
import kg.bishkoteka.data.remote.apiservice.events.PagingApiService
import kg.bishkoteka.data.models.post.organization.OrganizationCreateRequest
import kg.bishkoteka.data.remote.remoteDataSource.RemoteDataSource
import javax.inject.Inject

class OrganizationRepository @Inject constructor(
    private val dataSource: RemoteDataSource,
    private val apiService: PagingApiService,
    private val userPreferences: UserPreferences
) : BaseRepository() {

    fun createOrganization(organization: OrganizationCreateRequest) = doRequest { dataSource.createOrganization(organization) }
    fun getMyOrganizations() = doRequest { dataSource.getMyOrganizations(userPreferences.userID.toString().toInt()) }

    fun getMyOrganizationById(organizationId: Int) = doRequest { dataSource.getOrganizationById(organizationId) }

}