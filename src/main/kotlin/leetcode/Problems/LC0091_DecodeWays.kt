fun main() {

}

fun asdf(s: String): Int {
    val result = IntArray(s.length + 1)
    result[0] = 1
    result[1] = if (s[0] == '0') 0 else 1
    for (i in 2..s.length) {
        val d1: Int = Integer.valueOf(s.substring(i - 1, i))
        val d2: Int = Integer.valueOf(s.substring(i - 2, i))
        if (d1 >= 1) result[i] += result[i - 1]
        if (d2 in 10..26) result[i] += result[i - 2]
    }

    return result.last()
}
/*
int []arr = new int[s.length()+1];
    arr[0]=1;
    arr[1]=s.charAt(0)=='0'? 0:1;
    for(int i=2;i<=s.length();i++){
        int d1 = Integer.valueOf(s.substring(i-1,i));
        int d2 = Integer.valueOf(s.substring(i-2,i));
        if(d1>=1){
            arr[i]+=arr[i-1];
        }
        if(d2>=10 && d2<=26){
            arr[i]+=arr[i-2];

        }

    }
    return arr[s.length()];
 */