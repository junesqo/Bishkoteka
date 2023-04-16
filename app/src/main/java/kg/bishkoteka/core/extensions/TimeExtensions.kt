package kg.bishkoteka.core.extensions

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

fun Instant.toLocalDateTime(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime {
    return LocalDateTime.ofInstant(this, zoneId)
}

//fun Long.toDate(timestamp: Timestamp) {
//    val sdf = SimpleDateFormat("HH:mm, dd MMMM yyyy ")
//}

fun Long.toDate(): String {
    val date = Date(this * 1000) // convert Unix timestamp to milliseconds
    val format = SimpleDateFormat("HH:mm, dd MMMM yyyy", Locale.getDefault())
    return format.format(date)
}

fun Long.getDay(): String {
    val date = Date(this * 1000)
    val format = SimpleDateFormat("dd", Locale.getDefault())
    return format.format(date)
}