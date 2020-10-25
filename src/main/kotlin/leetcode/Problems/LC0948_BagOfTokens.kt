fun main() {

}

fun bagOfTokensScore(tokens: IntArray, P: Int): Int {
    var left = 0
    var right = tokens.size - 1
    var p = P
    var points = 0
    tokens.sort()

    while (left <= right) {
        if (tokens[left] <= p) {
            p -= tokens[left++]
            points++
        } else if (points > 0 && right - 1 > left) {
            p += tokens[right--]
            points--
        } else {
            left++
        }
    }

    return points
}

/*
int i = 0;
int j = tokens.length-1;
int points = 0;
Arrays.sort(tokens);

while (i <= j) {
    if (tokens[i] <= p) {
        p = p-tokens[i++];
        points++;
    } else if (points > 0 && j-1 > i) {
        p = p+tokens[j--];
        points--;
    } else {
        i++;
    }
}
return points;
 */