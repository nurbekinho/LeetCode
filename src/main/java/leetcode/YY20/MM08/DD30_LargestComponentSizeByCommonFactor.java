package leetcode.YY20.MM08;

import java.util.HashMap;
import java.util.Map;

public class DD30_LargestComponentSizeByCommonFactor {
    public static void main(String[] args) {
        System.out.println(largestComponentSize(new int[]{2, 3, 6, 7, 4, 12, 21, 39}));
    }

    public static int largestComponentSize(int[] A) {
        if (A == null || A.length == 0) return 0;
        int max = A[0];
        for (int num : A) max = Math.max(max,num);

        int[] roots = new int[max + 1];
        for (int i = 1; i < roots.length; i++) roots[i] = i;

        for (int num : A) {
            for(int factor = (int) Math.sqrt(num); factor >= 2; factor--) {
                if (num % factor == 0){
                    roots[find(roots,num)] = roots[find(roots, factor)];
                    roots[find(roots,num)] = roots[find(roots, num / factor)];
                }
            }
        }

        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : A) {
            int ancestor = find(roots, num);
            map.put(ancestor, map.getOrDefault(ancestor,0) + 1);
            result = Math.max(result, map.get(ancestor));
        }

        return result;
    }

    private static int find(int[] roots, int num) {
        return roots[num] == num ? num : (roots[num] = find(roots,roots[num]));
    }
}
