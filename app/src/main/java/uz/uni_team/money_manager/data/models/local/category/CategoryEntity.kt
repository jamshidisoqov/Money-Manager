package uz.uni_team.money_manager.data.models.local.category

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import uz.uni_team.money_manager.data.models.local.account.AccountsEntity

@Entity(tableName = "categories", foreignKeys = [ForeignKey(
    entity = AccountsEntity::class,
    parentColumns = ["id"],
    childColumns = ["account_id"],
    onDelete = ForeignKey.CASCADE,
    onUpdate = ForeignKey.CASCADE
)])
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "category_name")
    val categoryName:String,
    @ColumnInfo(name = "parent_id")
    val parentId:Int?,
    @ColumnInfo(name = "child_categories_ids")
    val childCategories:List<Int>,
    @ColumnInfo(name ="account_id")
    val accountId:Int
)
