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
    val childCategories:LongArray,
    @ColumnInfo(name ="account_id")
    val accountId:Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CategoryEntity

        if (id != other.id) return false
        if (categoryName != other.categoryName) return false
        if (parentId != other.parentId) return false
        if (!childCategories.contentEquals(other.childCategories)) return false
        if (accountId != other.accountId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + categoryName.hashCode()
        result = 31 * result + (parentId ?: 0)
        result = 31 * result + childCategories.contentHashCode()
        result = 31 * result + accountId
        return result
    }
}
