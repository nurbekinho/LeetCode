package leetcode.YY20.MM08;

public class DD14_LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aeeefffffg"));
    }

    public static int longestPalindrome(String s) {
        int[] letters = new int[52];

        for (int i = 0; i < s.length(); i++){
            if (Character.isUpperCase(s.charAt(i))) letters[s.charAt(i) - 'A' + 26]++;
            else letters[s.charAt(i) - 'a']++;
        }

        int length = 0;
        for (int i = 0; i < letters.length; i++) {
            length += letters[i] % 2 == 0 ? letters[i] : letters[i] - 1;
        }
        return length == s.length() ? s.length() : length + 1;
    }
}
