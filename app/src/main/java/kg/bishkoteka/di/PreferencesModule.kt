package kg.bishkoteka.di

import android.content.Context
import android.content.SharedPreferences
import kg.bishkoteka.data.local.preferences.PreferencesKeys.BISHKOTEKA_SHARED_PREFERENCES
import kg.bishkoteka.data.local.preferences.UserPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {

    @Singleton
    @Provides
    fun generateSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(
            BISHKOTEKA_SHARED_PREFERENCES,
            Context.MODE_PRIVATE
        )

    @Singleton
    @Provides
    fun generateUserPreferences(sharedPreferences: SharedPreferences) =
        UserPreferences(sharedPreferences)
}