package uz.uni_team.money_manager.utils

import java.math.BigDecimal
import java.text.DecimalFormat


const val FORMAT = "#.###"

fun BigDecimal?.addWhiteSpace():String{
    val formatter = DecimalFormat(FORMAT)
    return formatter.format(this?:BigDecimal.ZERO)
}