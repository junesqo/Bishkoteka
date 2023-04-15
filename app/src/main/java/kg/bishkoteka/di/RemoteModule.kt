package kg.bishkoteka.di

import kg.bishkoteka.data.remote.NetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kg.bishkoteka.data.remote.NetworkFastBuilder
import kg.bishkoteka.data.remote.apiservice.events.EventsApiService
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Singleton
    @Provides
    fun generateAuthenticationApiService(networkClient: NetworkClient.AuthenticationNetworkClient) =
        networkClient.generateAuthenticationApiService()

    @Singleton
    @Provides
    fun generateRefreshAccessTokensApiService(networkClient: NetworkClient.AuthenticationNetworkClient) =
        networkClient.generateRefreshAccessTokenApiService()

    @Singleton
    @Provides
    fun generateUserApiService(networkClient: NetworkClient) =
        networkClient.generateUserApiService()

    @Singleton
    @Provides
    fun generatePagingApiService(networkClient: NetworkClient) =
        networkClient.generatePagingApiService()

    @Singleton
    @Provides
    fun generateEventsApiService(networkClient: NetworkClient) =
        networkClient.generateEventsApiService()
}


