package uz.uni_team.money_manager.data.models.local.monem

import androidx.room.ColumnInfo
import java.math.BigDecimal

data class MonemAmount(
    @ColumnInfo("monem_type") val type: MonemType,
    @ColumnInfo(name = "amount") val amount: BigDecimal
)
