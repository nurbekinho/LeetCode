fun main() {

}

fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    var tank = 0
    var start = 0
    var sum = 0

    for (i in gas.indices) {
        sum += gas[i] - cost[i]
        tank += gas[i] - cost[i]
        if (tank < 0) {
            start = i + 1
            tank = 0
        }
    }

    return if (sum < 0) -1 else start
}