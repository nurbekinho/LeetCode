package leetcode.YY20.MM04;

public class DD09_BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a##c", "#a#c"));
        System.out.println(backspaceCompare("a#c", "b"));
    }

    public static boolean backspaceCompare(String S, String T) {
        int remove = 0;
        StringBuilder ssb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            char current = S.charAt(i);

            if (current == '#') {
                remove++;
                continue;
            }

            if (remove > 0) {
                remove--;
                continue;
            }

            ssb.append(current);
        }

        remove = 0;
        StringBuilder tsb = new StringBuilder();
        for (int i = T.length() - 1; i >= 0; i--) {
            char current = T.charAt(i);

            if (current == '#') {
                remove++;
                continue;
            }

            if (remove > 0) {
                remove--;
                continue;
            }

            tsb.append(current);
        }

        return ssb.toString().equals(tsb.toString());
    }
}
