package uz.uni_team.money_manager.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import uz.uni_team.money_manager.data.local.MonemDatabase
import uz.uni_team.money_manager.data.local.dao.account.AccountDao
import uz.uni_team.money_manager.data.local.dao.category.CategoryDao
import uz.uni_team.money_manager.data.local.dao.monem.MonemDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDatabaseModule {

    val scope = CoroutineScope(Dispatchers.IO)

    private const val SHARED_NAME = "app_shared_prefs"

    @[Provides Singleton]
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)

    @[Provides Singleton]
    fun provideRoomDatabase(@ApplicationContext context: Context): MonemDatabase =
        Room.databaseBuilder(context, MonemDatabase::class.java, MonemDatabase.DB_NAME)
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    val accountDao = provideRoomDatabase(context).getAccountDao()
                    val job = scope.launch(Dispatchers.IO) {
                        accountDao.initialAccountAdded()
                    }
                    if (job.isCompleted) {
                        scope.cancel()
                    }
                }
            }).build()

    @[Provides Singleton]
    fun provideAccountDao(monemDatabase: MonemDatabase): AccountDao = monemDatabase.getAccountDao()

    @[Provides Singleton]
    fun provideCategoryDao(monemDatabase: MonemDatabase): CategoryDao =
        monemDatabase.getCategoryDao()

    @[Provides Singleton]
    fun provideMonemDao(monemDatabase: MonemDatabase): MonemDao = monemDatabase.getMonemDao()
}