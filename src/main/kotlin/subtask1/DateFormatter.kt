package subtask1

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {

        var currentYear = year.toInt()
        var currentMonth = month.toInt()

        return if (day.toInt() < 1 || day.toInt() > 31 || currentMonth < 1 || currentMonth > 12 ||
            (month == "2" && currentYear % 4 != 0  && day.toInt() > 28)) "Такого дня не существует"
        else {
            if (month.toInt() < 3) {
                currentYear--
                currentMonth += 10
            } else currentMonth -= 2

            val dayOfTheWeek = (day.toInt() + (31 * currentMonth) / 12 + currentYear + currentYear / 4 - currentYear / 100 + currentYear / 400) % 7
            val outputMonth = when (month.toInt()) {
                1 -> "января"
                2 -> "февраля"
                3 -> "марта"
                4 -> "апреля"
                5 -> "мая"
                6 -> "июня"
                7 -> "июля"
                8 -> "августа"
                9 -> "сентября"
                10 -> "октября"
                11 -> "ноября"
                else -> "декабря"
            }

            val outputDay = when (dayOfTheWeek) {
                1 -> "понедельник"
                2 -> "вторник"
                3 -> "среда"
                4 -> "четверг"
                5 -> "пятница"
                6 -> "суббота"
                else -> "воскресенье"
            }

           "$day $outputMonth, $outputDay"
        }

    }

}
