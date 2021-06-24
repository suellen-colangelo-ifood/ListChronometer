package br.com.suellencolangelo.listchronometer.list

import java.util.Date

data class TimerModel(
    var formattedTime: String,
    val finalTimeMills: Long,
    val timeNotifyIntervalMills: Long,
) {
    val timeIntervalMills : Long
    get() {
        return if (Date().time >= finalTimeMills) {
            0
        } else {
            finalTimeMills - Date().time
        }
    }
}
