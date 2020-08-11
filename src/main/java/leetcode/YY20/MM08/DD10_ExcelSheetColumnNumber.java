package leetcode.YY20.MM08;

public class DD10_ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ABC"));
    }

    public static int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) result = s.charAt(i) - 'A' + 1 + result * 26;

        return result;
    }
}
