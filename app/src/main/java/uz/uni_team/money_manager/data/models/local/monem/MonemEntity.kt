package uz.uni_team.money_manager.data.models.local.monem

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import uz.uni_team.money_manager.data.models.local.account.AccountsEntity
import uz.uni_team.money_manager.data.models.local.category.CategoryEntity
import java.math.BigDecimal
import java.util.Date

@Entity(
    tableName = "monem", foreignKeys = [ForeignKey(
        entity = CategoryEntity::class,
        parentColumns = ["id"],
        childColumns = ["category_id"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    ), ForeignKey(
        entity = AccountsEntity::class,
        parentColumns = ["id"],
        childColumns = ["account_id"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )]
)
data class MonemEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "category_id") val categoryId: Int,
    @ColumnInfo(name = "amount") val amount: BigDecimal,
    @ColumnInfo(name = "type") val monemType: MonemType,
    @ColumnInfo(name = "is_sync") val isSync: Boolean,
    @ColumnInfo(name = "time") val time: Date?,
    @ColumnInfo(name = "info") val description: String?,
    @ColumnInfo(name = "is_draft") val isDraft: Boolean?,
    @ColumnInfo(name = "is_remember_in_time") val isRemember: Boolean?,
    @ColumnInfo(name = "account_id") val accountId: Int,
    @ColumnInfo(name = "sender_phone") val phone: String?,
    @ColumnInfo(name = "sender_message") val message: String?
)