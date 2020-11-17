import kotlin.math.max

fun main() {

}

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.isEmpty()) return emptyArray()

    intervals.sortWith(compareBy { it[0] })
    val result = mutableListOf<IntArray>()
    var i = 0
    var id = 0
    var current = intervals[0]
    while (i < intervals.size) {
        while (i < intervals.size && intervals[i][0] <= current[1]) {
            current[1] = max(current[1], intervals[i++][1])
        }
        result.add(current)
        current = if (i < intervals.size) intervals[i] else intArrayOf()
    }

    return result.toTypedArray()
}

/*
if(intervals == null || intervals.length == 0)
    return intervals;
List<int[]> ret = new ArrayList<>();
Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
int i = 0, idx = 0, curr[] = intervals[0];
while(i < intervals.length){
    while(i < intervals.length && intervals[i][0] <= curr[1])
        curr[1] = Math.max(curr[1], intervals[i++][1]);
    ret.add(curr);
    curr =  i < intervals.length ? intervals[i]: new int[]{};
}
int result[][] = new int[ret.size()][2];
for(int[] arr : ret)
    result[idx++] = arr;
return result;
 */