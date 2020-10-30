import kotlin.math.max

fun main() {

}

fun maxDistToClosest(seats: IntArray): Int {
    var start = -1
    var end = 0
    var max = 0
    while (start <= end && end < seats.size) {
        if (seats[end] == 1) {
            max = if (start == -1) end else max(max, (end - start) / 2)
            start = end
        }
        end++
    }

    if (start != seats.size - 1) max = max(max, end - start - 1)
    return max
}

/*
int start = -1,end = 0, max = 0;

while(start <= end && end < seats.length) {
    if(seats[end] == 1) {
        max = (start == -1) ? end : Math.max(max,(end-start)/2);
        start = end;
    }
    end++;
}

if(start != seats.length-1)
    max = Math.max(max,end-start-1);

return max;
 */