package leetcode.YY20.MM08;

import java.util.ArrayList;
import java.util.List;

public class DD29_PancakeSorting {
    public static void main(String[] args) {
        System.out.println(pancakeSort(new int[]{3, 2, 4, 1}));
    }

    public static List<Integer> pancakeSort(int[] a) {
        List<Integer> result = new ArrayList<>();
        int index = a.length - 1;
        while (index != 0) {
            if (a[index] != index + 1) {
                int fIndex = -1;
                for (int i = 0; i < index; i++) {
                    if (a[i] == index + 1) {
                        result.add(i + 1);
                        fIndex = i;
                        break;
                    }
                }

                reverse(a, fIndex);
                result.add(index + 1);
                reverse(a, index);
            }

            index--;
        }

        return result;
    }

    private static void reverse(int[] a, int index) {
        int left = 0;
        int right = index;
        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }
}
