package kg.bishkoteka.di

import kg.bishkoteka.remote.NetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}


