package kg.bishkoteka.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kg.bishkoteka.data.repositories.EventsRepositoryImpl
import kg.bishkoteka.domain.repositories.EventsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindEventsRepository(eventsRepositoryImpl: EventsRepositoryImpl): EventsRepository
}