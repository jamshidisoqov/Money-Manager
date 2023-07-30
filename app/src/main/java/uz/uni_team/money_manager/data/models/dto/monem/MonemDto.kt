package uz.uni_team.money_manager.data.models.dto.monem

import uz.uni_team.money_manager.data.models.local.monem.MonemType
import java.math.BigDecimal
import java.util.Date

data class MonemDto(
    val id: Long,
    val categoryId: Int,
    val amount: BigDecimal,
    val monemType: MonemType,
    val time: Date?,
    val description: String?,
    val isDraft: Boolean?,
    val isRemember: Boolean?,
    val accountId: Int,
    val phone: String?,
    val message: String?
)
