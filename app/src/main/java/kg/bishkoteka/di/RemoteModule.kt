package kg.bishkoteka.di

import kg.bishkoteka.data.remote.NetworkClient
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
    fun generateAuthenticationApiService(networkClient: NetworkClient) =
        networkClient.generateAuthenticationApiService()
}