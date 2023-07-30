package uz.uni_team.money_manager.data.local.dao.category

import androidx.room.Dao
import uz.uni_team.money_manager.data.local.dao.BaseDao
import uz.uni_team.money_manager.data.models.local.category.CategoryEntity

@Dao
interface CategoryDao : BaseDao<CategoryEntity> {
}