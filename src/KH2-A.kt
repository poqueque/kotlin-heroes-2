
fun main() {
    val dataLength = readLine()!!.toInt()
    val list = readLine()!!.split(' ').map(String::toInt)
    val needed = 3
    val selected = mutableMapOf<Int,Int>()

    list.takeWhile { selected.size < needed }.forEachIndexed{ index, value ->
        if (!selected.values.contains(value)){
            selected[index] = value
        }
    }

    val sortedSelected = selected.toList().sortedBy { (_, value) -> value}.take(needed).toMap()

    if (sortedSelected.size < needed)
        print ("-1 -1 -1")
    else for (entry in sortedSelected)
        print ("${entry.key+1} ")
}