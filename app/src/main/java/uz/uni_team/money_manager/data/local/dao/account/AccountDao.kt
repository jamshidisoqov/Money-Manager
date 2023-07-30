package uz.uni_team.money_manager.data.local.dao.account

import androidx.room.Dao
import androidx.room.Query
import uz.uni_team.money_manager.data.local.dao.BaseDao
import uz.uni_team.money_manager.data.models.local.account.AccountsEntity

@Dao
interface AccountDao:BaseDao<AccountsEntity> {
    @Query("SELECT*FROM accounts")
    suspend fun getAccountList():List<AccountsEntity>
}