import kotlin.math.min

//Not passed

fun main() {
    val (n, a, b, k) = readLine()!!.split(' ').map(String::toInt)
    val ratings = readLine()!!.split(' ').map(String::toLong).toMutableList()

    val distinctRatings = ratings.distinct()
    var groups = 0
    distinctRatings.forEach { rating ->
        val peopleA = ratings.count { it == rating }
        var peopleB = ratings.count { it == rating*k }
        if (k==1) peopleB -= peopleA
        val groupsA = peopleA / a
        val groupsB = peopleB / b
        val groupsToAdd = min(groupsA,groupsB)
        repeat(groupsToAdd) {
            ratings.remove(rating)
            ratings.remove(rating*k)
        }
        groups += groupsToAdd
    }

    print("$groups")
}