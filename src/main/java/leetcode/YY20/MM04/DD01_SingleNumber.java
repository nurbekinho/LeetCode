package leetcode.YY20.MM04;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DD01_SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1}) == 1);
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}) == 4);
    }

    public static int singleNumber(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ) )
                .entrySet()
                .stream()
                .filter( p -> p.getValue() == 1 )
                .map( Map.Entry::getKey )
                .collect( Collectors.toList() ).get(0);
    }
}
