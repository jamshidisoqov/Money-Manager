package uz.uni_team.money_manager.data.local.dao.monem

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import uz.uni_team.money_manager.data.local.dao.BaseDao
import uz.uni_team.money_manager.data.models.local.monem.MonemAmount
import uz.uni_team.money_manager.data.models.local.monem.MonemEntity
import java.util.Date

@Dao
interface MonemDao : BaseDao<MonemEntity> {
    @Query(
        """
    SELECT * 
    FROM monem 
    WHERE 1 = 1
        and category_id IN (:categoryIds) 
        and (case when :startDate is not null and time >= :startDate then 1 else 0 end) = 1
        and (case when :endDate is not null and time <= :endDate then 1 else 0 end) = 1
        and monem_name LIKE '%' || :query || '%'
        limit :limit
        offset :offset
    """
    )
    suspend fun getMonemByFilters(
        categoryIds: List<Int>,
        query: String,
        startDate: Date?,
        endDate: Date?,
        offset: Int,
        limit: Int
    ): List<MonemEntity>

    @Query(
        """
            select monem_type,sum(amount) as amount
            from monem
            where 1 = 1
                group by(monem_type)
        """
    )
    suspend fun getAllIncomeExpansesAndBalance(): List<MonemAmount>

}