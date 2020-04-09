package subtask2

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String {

        var minutes = minute.toInt()
        val hours = hour.toInt()

        return if (minutes > 59 || minutes < 0) ""
        else {
            val numbersTill19 = arrayOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
            "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
            val tens = arrayOf("twenty", "thirty", "forty", "fifty")

            if (minutes < 30)
                if (minutes < 20)
                    when (minutes) {
                        0 -> "${numbersTill19[hours]} o' clock"
                        15 -> "quarter past ${numbersTill19[hours]}"
                        else -> "${numbersTill19[minutes]} minutes past ${numbersTill19[hours]}"
                    }
                else {
                    "${tens[0]} ${numbersTill19[minutes % 10]} minutes past ${numbersTill19[hours]}"
                }
            else if (minutes == 30) "half past ${numbersTill19[hours]}"
            else if (minutes == 45) "quarter to ${numbersTill19[hours + 1]}"
            else {
                minutes = 60 - minutes
                if ((minutes / 10) > 0) "${tens[(minutes / 10) - 2]} ${numbersTill19[minutes % 10]} minutes to ${numbersTill19[hours + 1]}"
                else "${numbersTill19[minutes % 10]} minutes to ${numbersTill19[hours + 1]}"
            }

        }

    }

}
