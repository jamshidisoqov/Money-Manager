package uz.uni_team.money_manager.data.models.dto.monem

import uz.uni_team.money_manager.data.models.local.monem.MonemType
import java.math.BigDecimal

data class MonemAmountDto(
    val type: MonemType,
    val amount: BigDecimal
)
