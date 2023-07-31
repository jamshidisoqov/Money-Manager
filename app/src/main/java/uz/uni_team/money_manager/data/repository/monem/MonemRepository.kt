package uz.uni_team.money_manager.data.repository.monem

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import uz.uni_team.money_manager.data.local.dao.monem.MonemDao
import uz.uni_team.money_manager.data.models.dto.monem.MonemDto
import java.util.Date
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MonemRepository @Inject constructor(
  private val monemDao: MonemDao
) {
    suspend fun getAllMonemTransactions(
        categoryIds: List<Int>,
        query: String,
        startDate: Date?,
        endDate: Date?,
        page: Int,
        pageSize: Int
    ): List<MonemDto> {
        return withContext(Dispatchers.IO) {
            monemDao.getMonemByFilters(
                categoryIds = categoryIds,
                query = query,
                startDate = startDate,
                endDate = endDate,
                offset = pageSize*(page-1),
                limit = pageSize
            )
            emptyList()
        }
    }

}