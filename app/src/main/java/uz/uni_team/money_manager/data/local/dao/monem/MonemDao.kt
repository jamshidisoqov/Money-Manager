package uz.uni_team.money_manager.data.local.dao.monem

import androidx.room.Dao
import androidx.room.Query
import uz.uni_team.money_manager.data.local.dao.BaseDao
import uz.uni_team.money_manager.data.models.local.monem.MonemAmount
import uz.uni_team.money_manager.data.models.local.monem.MonemEntity
import uz.uni_team.money_manager.data.models.local.monem.MonemType
import java.math.BigDecimal
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

    // INCOME, EXPANSES, IN_DEBT, OUT_DEBT,BALANCE
    /* @Transaction
     @Query(
         """
     SELECT types.*,sum(types.INCOME+types.IN_DEBT-types.OUT_DEBT-types.EXPANSES) as BALANCE
     FROM (
         SELECT
             sum(case when type = 'INCOME' then amount else 0 end) as INCOME,
             sum(case when type = 'EXPANSES' then amount else 0 end) as EXPANSES,
             sum(case when type = 'IN_DEBT' then amount else 0 end) as IN_DEBT,
             sum(case when type = 'OUT_DEBT' then amount else 0 end) as OUT_DEBT
         FROM monem
     ) as types
     """
     )
     suspend fun getAllIncomeExpansesAndBalanceMap(): Any*/

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