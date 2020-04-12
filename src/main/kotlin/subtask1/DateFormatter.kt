package subtask1

import java.util.*

class DateFormatter {

    // TODO: Complete the following function
    fun toTextDay(dayParam: String, monthParam: String, yearParam: String): String {

        val day = dayParam.toInt()
        val month = monthParam.toInt()
        var year = yearParam.toInt()
        var dayOfWeek = ""
        var dayOfWeekNumber: Int
        var monthStr = ""
        var yearAdditionalNumber = 0
        var monthAdditionalNumber = 0
        var isLeap = false
        var wrongDate = false

        if (year % 4 == 0 && year % 400 != 0) isLeap = true

        if (
            (month !in 1..12) ||
            (day !in 1..31) ||
            (!isLeap && month == 2 && day > 28) ||
            (month == 2 && day > 29) ||
            (month == 4 && day > 30) ||
            (month == 6 && day > 30) ||
            (month == 9 && day > 30) ||
            (month == 11 && day > 30))
            return "Такого дня не существует"

        while (year >= 400) year -= 400
        when (year){
            in 0..99 -> yearAdditionalNumber = 6
            in 100..199 -> yearAdditionalNumber = 4
            in 200..299 -> yearAdditionalNumber = 2
            in 300..399 -> yearAdditionalNumber = 0
        }



        when (month){
            1 -> {monthAdditionalNumber = 0; monthStr = "января"}
            2 -> {monthAdditionalNumber = 3; monthStr = "февраля"}
            3 -> {monthAdditionalNumber = 3; monthStr = "марта"}
            4 -> {monthAdditionalNumber = 6; monthStr = "апреля"}
            5 -> {monthAdditionalNumber = 1; monthStr = "мая"}
            6 -> {monthAdditionalNumber = 4; monthStr = "июня"}
            7 -> {monthAdditionalNumber = 6; monthStr = "июля"}
            8 -> {monthAdditionalNumber = 2; monthStr = "августа"}
            9 -> {monthAdditionalNumber = 5; monthStr = "сентября"}
            10 -> {monthAdditionalNumber = 0; monthStr = "октября"}
            11 -> {monthAdditionalNumber = 3; monthStr = "ноября"}
            12 -> {monthAdditionalNumber = 5; monthStr = "декабря"}
        }

        year = year.toString().takeLast(2).toInt()
        dayOfWeekNumber = (year + (year / 4) + day +
                           monthAdditionalNumber + yearAdditionalNumber) % 7

        if (isLeap && (month == 1 || month == 2)) dayOfWeekNumber--

        when (dayOfWeekNumber){
            0 -> dayOfWeek = "воскресенье"
            1 -> dayOfWeek = "понедельник"
            2 -> dayOfWeek = "вторник"
            3 -> dayOfWeek = "среда"
            4 -> dayOfWeek = "четверг"
            5 -> dayOfWeek = "пятниа"
            6 -> dayOfWeek = "суббота"
        }


        return("$day $monthStr, $dayOfWeek")

        throw NotImplementedError("Not implemented")
    }
}
