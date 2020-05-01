package April2020;

import java.util.Stack;

public class Day16_ValidParenthesisString {
    public static void main(String[] args) {
        System.out.println(checkValidString("()"));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*))"));
        System.out.println(checkValidString("))*((((**)*))"));
    }

    public static boolean checkValidString(String s) {
        Stack<Character> leftStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '*') leftStack.push(c);
            else if (!leftStack.isEmpty()) leftStack.pop();
            else return false;
        }

        Stack<Character> rightStack = new Stack<>();
        for (char c : new StringBuilder(s).reverse().toString().toCharArray()) {
            if (c==')' || c =='*') rightStack.push(c);
            else if(!rightStack.isEmpty()) rightStack.pop();
            else return false;
        }

        return true;
    }
}
