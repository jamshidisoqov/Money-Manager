package uz.uni_team.money_manager.data.local

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteOpenHelper
import uz.uni_team.money_manager.data.local.convertors.RoomTypeConverters
import uz.uni_team.money_manager.data.local.dao.account.AccountDao
import uz.uni_team.money_manager.data.local.dao.category.CategoryDao
import uz.uni_team.money_manager.data.local.dao.monem.MonemDao
import uz.uni_team.money_manager.data.models.local.account.AccountsEntity
import uz.uni_team.money_manager.data.models.local.category.CategoryEntity
import uz.uni_team.money_manager.data.models.local.monem.MonemEntity

@TypeConverters(RoomTypeConverters::class)
@Database(
    entities = [AccountsEntity::class, CategoryEntity::class, MonemEntity::class],
    version = MonemDatabase.MONEM_DB_VERSION,
    exportSchema = false
)
abstract class MonemDatabase : RoomDatabase() {

    abstract fun getAccountDao():AccountDao

    abstract fun getCategoryDao():CategoryDao

    abstract fun getMonemDao():MonemDao

    companion object {
        const val MONEM_DB_VERSION = 1
        const val DB_NAME = "monem_database.db"
    }
}