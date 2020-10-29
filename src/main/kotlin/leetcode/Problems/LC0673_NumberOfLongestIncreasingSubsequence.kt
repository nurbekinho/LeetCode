import kotlin.math.max

fun main() {

}

fun findNumberOfLIS(nums: IntArray): Int {
    if (nums.size <= 1) return nums.size

    var max = 0
    var answer = 0
    val length = IntArray(nums.size)
    val count = IntArray(nums.size)

    for (i in nums.indices) {
        var flag = true
        for (j in 0 until i) {
            if (nums[i] > nums[j]) {
                flag = false
                if (length[j] + 1 > length[i]) {
                    length[i] = length[j] + 1
                    count[i] = count[j]
                } else if (length[j] + 1 == length[i]) {
                    count[i] += count[j]
                }
            }
        }

        if (flag) {
            length[i] = 1
            count[i] = 1
        }
        max = max(max, length[i])
    }

    for (i in nums.indices) {
        if (length[i] == max) answer += count[i]
    }

    return answer
}

/*
for(int i=0;i<nums.length;i++){
    boolean flag = true;
    for(int j=0;j<i;j++){
        if(nums[i]>nums[j]){
            flag = false;
            if(length[j]+1>length[i]){
                length[i] = length[j]+1;
                count[i] = count[j];
            }else if(length[j]+1==length[i])
                count[i]+=count[j];
        }
    }
    if(flag)
        length[i] = count[i] = 1;
    omax = Math.max(omax,length[i]);
}

for(int i=0;i<nums.length;i++){
    if(length[i] == omax)
        ans+=count[i];
}

return ans;
 */