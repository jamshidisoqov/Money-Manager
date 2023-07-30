package uz.uni_team.money_manager.data.models.local.account

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts")
data class AccountsEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "account_name") val accountName: String,
    @ColumnInfo(name = "account_phone_number") val phoneNumber: String,
    @ColumnInfo(name = "account_is_verify") val isVerify: Boolean?,
    @ColumnInfo(name = "account_type") val accountType: AccountType,
    @ColumnInfo(name = "is_premium") val isPremium:Boolean?,
    @ColumnInfo(name = "account_email") val email:String?,
    @ColumnInfo(name = "account_image_url") val imageUrl:String,
    @ColumnInfo(name = "account_password") val password:String?

)