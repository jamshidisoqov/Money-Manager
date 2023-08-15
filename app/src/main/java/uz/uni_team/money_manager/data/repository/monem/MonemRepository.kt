package uz.uni_team.money_manager.data.repository.monem

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import uz.uni_team.money_manager.data.local.dao.monem.MonemDao
import uz.uni_team.money_manager.data.mapper.monem.toMonemAmountDto
import uz.uni_team.money_manager.data.mapper.monem.toMonemDto
import uz.uni_team.money_manager.data.models.dto.monem.MonemAmountDto
import uz.uni_team.money_manager.data.models.dto.monem.MonemDto
import uz.uni_team.money_manager.data.models.dto.monem.MonemTypeDto
import uz.uni_team.money_manager.data.models.local.monem.MonemType
import java.math.BigDecimal
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
                offset = pageSize * (page - 1),
                limit = pageSize
            ).toMonemDto()
        }
    }

    fun calculateIncomeExpansesAndBalance(): Flow<Map<MonemTypeDto, BigDecimal>> = flow {
        emit(getAmountTypes(monemDao.getAllIncomeExpansesAndBalance().toMonemAmountDto()))
    }.flowOn(Dispatchers.IO)

    private fun getAmountTypes(list: List<MonemAmountDto>): Map<MonemTypeDto, BigDecimal> {
        val income = list.find { it.type == MonemType.INCOME }?.amount ?: BigDecimal.ZERO
        val expanses = list.find { it.type == MonemType.EXPANSES }?.amount ?: BigDecimal.ZERO
        val balance = list.sumOf {
            if (it.type == MonemType.INCOME || it.type == MonemType.OUT_DEBT) {
                it.amount
            } else {
                it.amount.multiply(BigDecimal(-1))
            }
        }
        return mapOf(
            MonemTypeDto.EXPANSES to expanses,
            MonemTypeDto.INCOME to income,
            MonemTypeDto.BALANCE to balance
        )
    }
}