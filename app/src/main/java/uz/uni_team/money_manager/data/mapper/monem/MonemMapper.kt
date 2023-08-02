package uz.uni_team.money_manager.data.mapper.monem

import uz.uni_team.money_manager.data.models.dto.monem.MonemAmountDto
import uz.uni_team.money_manager.data.models.dto.monem.MonemDto
import uz.uni_team.money_manager.data.models.local.monem.MonemAmount
import uz.uni_team.money_manager.data.models.local.monem.MonemEntity

fun MonemAmount.toMonemAmountDto(): MonemAmountDto = MonemAmountDto(type = type, amount = amount)
fun List<MonemAmount>.toMonemAmountDto(): List<MonemAmountDto> = this.map { it.toMonemAmountDto() }

fun MonemEntity.toMonemDto(): MonemDto = MonemDto(
    id = id,
    categoryId = categoryId,
    amount = amount,
    monemType = monemType,
    time = time,
    description = description,
    isDraft = isDraft,
    isRemember = isRemember,
    accountId = accountId,
    phone = phone,
    message = message
)

fun List<MonemEntity>.toMonemDto(): List<MonemDto> = this.map { it.toMonemDto() }