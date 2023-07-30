package uz.uni_team.money_manager.data.models.dto.account

data class AccountDto(
    val id: Int,
    val type: AccountTypeDto,
    val accountName: String,
    val phoneNumber: String,
    val isVerify: Boolean?,
    val isPremium: Boolean?,
    val email: String?,
    val imageUrl: String,
    val password: String?
)
