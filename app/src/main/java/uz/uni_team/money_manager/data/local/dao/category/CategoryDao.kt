package uz.uni_team.money_manager.data.local.dao.category

import androidx.room.Dao
import androidx.room.Query
import uz.uni_team.money_manager.data.local.dao.BaseDao
import uz.uni_team.money_manager.data.models.local.category.CategoryEntity

@Dao
interface CategoryDao : BaseDao<CategoryEntity> {

    @Query(
        """ SELECT *
        FROM categories
        WHERE 1 = 1 
            and account_id = :accountId 
        """
    )
    suspend fun getAllCategoriesByAccountId(accountId: Int):List<CategoryEntity>
}