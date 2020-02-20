

fun main() {
    val dataLength = readLine()!!.toInt()
    val list = readLine()!!.split(' ').map(String::toLong)
    val max = list.max()!!
    val lastMax = list.lastIndexOf(max)
    val toSkipAtEnd = list.size-lastMax-1
    val totalCities = max * dataLength - toSkipAtEnd

    print ("$totalCities ")
}