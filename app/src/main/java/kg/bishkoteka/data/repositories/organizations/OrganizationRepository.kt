package kg.bishkoteka.data.repositories.organizations

import kg.bishkoteka.data.base.BaseRepository
import kg.bishkoteka.data.remote.apiservice.events.PagingApiService
import kg.bishkoteka.data.remote.dto.organization.CreateOrganizationDto
import kg.bishkoteka.data.remote.remoteDataSource.RemoteDataSource
import javax.inject.Inject

class OrganizationRepository @Inject constructor(
    private val dataSource: RemoteDataSource,
    private val apiService: PagingApiService,
) : BaseRepository() {

    fun createOrganization(organization: CreateOrganizationDto) = doRequest { dataSource.createOrganization(organization) }

}