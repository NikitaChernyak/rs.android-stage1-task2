package subtask5

import java.lang.StringBuilder
import kotlin.reflect.KClass
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        when (blockB) {
            String::class -> {
                val result = StringBuilder()
                for (i in blockA.indices)
                    if (blockA[i] is String)
                        result.append(blockA[i])
                return result.toString()
            }
            Int::class -> {
                var result = 0
                for (i in blockA.indices)
                    if (blockA[i] is Int)
                        result += blockA[i] as Int
                return result
            }
            LocalDate::class -> {
                val dates = arrayListOf<LocalDate>()
                var result: LocalDate
                for (i in blockA.indices)
                    if (blockA[i] is LocalDate)
                        dates.add(blockA[i] as LocalDate)
                val now = LocalDate.now()
                for (i in dates.indices) {
                    result = dates.max() ?: now
                    if (result > now) {
                        dates.remove(result)
                        continue
                    }
                    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
                    return result.format(formatter)
                }
            }

        }
        throw NotImplementedError("Not implemented")
    }

}
