package May2020;

public class Day13_RemoveKDigits {
    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("11", 2));
        System.out.println(removeKdigits("1234567", 2));
        System.out.println(removeKdigits("10", 1));
        System.out.println(removeKdigits("1234567890", 9));
    }

    public static String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";

        StringBuilder sb = new StringBuilder(num);
        for (int i = 1; i <= k; i++) {
            int index = 1;

            while (index<sb.length() && sb.charAt(index) >= sb.charAt(index - 1)) index++;

            sb.deleteCharAt(index - 1);

            while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);

            if (sb.length() == 0) return "0";
        }

        return sb.toString();
    }
}
