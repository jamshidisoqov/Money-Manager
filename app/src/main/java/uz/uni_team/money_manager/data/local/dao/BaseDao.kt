package uz.uni_team.money_manager.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

@Dao
interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(data:T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(collection: Collection<T>)

    @Update
    suspend fun update(data: T)

    @Update
    suspend fun update(data: Collection<T>)

    @Delete
    suspend fun delete(data: T)

    @Delete
    suspend fun delete(data: Collection<T>)
}