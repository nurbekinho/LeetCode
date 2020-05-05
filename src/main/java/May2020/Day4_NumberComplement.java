package May2020;

public class Day4_NumberComplement {
    public static void main(String[] args) {
        System.out.println(findComplement(5));
        System.out.println(findComplement(0));
        System.out.println(findComplement(1));
    }

    public static int findComplement(int num) {
        String bin = Integer.toBinaryString(num);
        StringBuilder result = new StringBuilder();
        for (char c : bin.toCharArray()) result.append(c == '1' ? "0" : "1");

        return Integer.parseInt(result.toString(), 2);
    }
}
