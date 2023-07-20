package uz.uni_team.money_manager.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDatabaseModule {

    @[Provides Singleton]
    fun provideSharedPreference(@ApplicationContext context: Context):SharedPreferences =
        context.getSharedPreferences("app_shared_prefs",Context.MODE_PRIVATE)

}