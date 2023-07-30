package uz.uni_team.money_manager.data.local.dao.account

import androidx.room.Dao
import uz.uni_team.money_manager.data.local.dao.BaseDao
import uz.uni_team.money_manager.data.models.local.account.AccountsEntity

@Dao
interface AccountDao:BaseDao<AccountsEntity> {

}