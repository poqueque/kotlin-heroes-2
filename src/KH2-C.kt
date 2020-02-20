data class Day(val min: Long, val max: Long, val price: Long)

fun main() {
    val (nL, k) = readLine()!!.split(' ').map(String::toLong)
    val n = nL.toInt()
    val list = mutableListOf<Day>()
    var remainingMin = 0L
    for (i in 0 until n) {
        val (a, b, c) = readLine()!!.split(' ').map(String::toLong)
        remainingMin += a
        list.add(Day(a, b, c))
    }

    list.sortBy { it.price }

    var eaten = 0L
    var spent = 0L
    list.forEach { day ->
        remainingMin -= day.min //Minimo de helados que le quedaran por tomar
        when {
            remainingMin + day.max + eaten <= k -> {
                eaten += day.max
                spent += day.price*day.max
            }
            remainingMin + day.min + eaten == k -> {
                eaten += day.min
                spent += day.price*day.min
            }
            else -> {
                var eatenToday = day.min
                eaten += day.min
                spent += day.price*day.min

                while (remainingMin + eaten < k) {
                    eaten++
                    eatenToday++
                    spent += day.price
                }
            }
        }
    }

    if (eaten != k)
        print("-1")
    else
        print("$spent")
}