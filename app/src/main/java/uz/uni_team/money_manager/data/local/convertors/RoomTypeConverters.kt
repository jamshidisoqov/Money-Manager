package uz.uni_team.money_manager.data.local.convertors

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.math.BigDecimal
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object RoomTypeConverters {
    private val dateFormat: DateFormat =
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale("uz", "UZ"))

    @JvmStatic
    @TypeConverter
    fun fromBigDecimal(bigDecimal: BigDecimal?): String? = bigDecimal?.toString()

    @JvmStatic
    @TypeConverter
    fun toBigDecimal(string: String?): BigDecimal? = string?.let { BigDecimal(it) }

    @JvmStatic
    @TypeConverter
    fun fromDate(date: Date?): String? = date?.time?.let { dateFormat.format(it) }

    @JvmStatic
    @TypeConverter
    fun toDate(string: String?): Date? = string?.let { dateFormat.parse(it) }

    @Suppress("EXPERIMENTAL_API_USAGE")
    @JvmStatic
    @TypeConverter
    fun fromLongArray(array: LongArray?): String? {
       return array.toJson()
    }

    @Suppress("EXPERIMENTAL_API_USAGE")
    @JvmStatic
    @TypeConverter
    fun toLongArray(string: String?): LongArray? = string?.let {
        return it.fromJson<List<Long>>().toLongArray()
    }

    @Suppress("EXPERIMENTAL_API_USAGE")
    @JvmStatic
    @TypeConverter
    fun fromStringArray(array: Array<String>?): String? = array?.let {
        return it.toJson()
    }

    @Suppress("EXPERIMENTAL_API_USAGE")
    @JvmStatic
    @TypeConverter
    fun toStringArray(string: String?): Array<String>? = string?.let {
        return it.fromJson<List<String>>().toTypedArray()
    }

    @TypeConverter
    fun fromStringArrayList(value: List<String>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toStringArrayList(value: String): List<String> {
        return try {
            Gson().fromJson<ArrayList<String>>(value) //using extension function
        } catch (e: Exception) {
            arrayListOf()
        }
    }

    private inline fun <reified T> Gson.fromJson(json: String) =
        fromJson<T>(json, object : TypeToken<T>() {}.type)
}

private inline fun <reified T> T.toJson(): String? {
    return Gson().toJson(this)
}

private inline fun <reified T> String.fromJson(): T {
    val type = object : TypeToken<T>() {}.type
    return Gson().fromJson(this, type)
}