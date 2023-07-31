package uz.uni_team.money_manager.data.local.dao.account

import androidx.room.Dao
import androidx.room.Query
import uz.uni_team.money_manager.data.local.dao.BaseDao
import uz.uni_team.money_manager.data.models.local.account.AccountType
import uz.uni_team.money_manager.data.models.local.account.AccountsEntity

@Dao
interface AccountDao : BaseDao<AccountsEntity> {
    @Query(
        """
            SELECT * 
            FROM accounts
        """
    )
    suspend fun getAccountList(): List<AccountsEntity>

    suspend fun initialAccountAdded() {
        for (i in 0..1) {
            this.insertOrReplace(
                AccountsEntity(
                    id = 0,
                    accountName = "undefined",
                    phoneNumber = "no input phone",
                    isVerify = false,
                    accountType = AccountType.values()[i],
                    isPremium = false,
                    email = null,
                    imageUrl = "",
                    password = null
                )
            )
        }
    }
}