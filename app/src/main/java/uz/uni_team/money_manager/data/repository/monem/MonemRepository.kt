package uz.uni_team.money_manager.data.repository.monem

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import uz.uni_team.money_manager.data.models.dto.monem.MonemDto
import java.util.Date
import javax.inject.Inject

class MonemRepository @Inject constructor(

) {
    suspend fun getAllMonemTransactions(
        categoryIds: List<Long>,
        query: String,
        startDate: Date?,
        endDate: Date?,
        page: Int,
        pageSize: Int
    ): List<MonemDto> {
        return withContext(Dispatchers.IO) {
            emptyList()
        }
    }
}