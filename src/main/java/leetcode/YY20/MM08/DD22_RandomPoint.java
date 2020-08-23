package leetcode.YY20.MM08;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DD22_RandomPoint {
    public static void main(String[] args) {

    }
}

class Solution {
    int area = 0;
    List<Integer> list = new ArrayList<>();
    int[][] rectangles;
    public Solution(int[][] rects) {
        rectangles = rects;
        for (int[] rect : rects) {
            area += (rect[2]-rect[0] + 1) * (rect[3] - rect[1] + 1);
            list.add(area);
        }
    }

    public int[] pick() {
        Random random = new Random();
        int rand = random.nextInt(area) + 1, i = 0;
        while (list.get(i) < rand) i++;
        int[] cord = rectangles[i];
        int num = list.get(i) - rand, width = cord[2] - cord[0] + 1;

        return new int[]{cord[0] + num%width, cord[1] + num/width};
    }
}