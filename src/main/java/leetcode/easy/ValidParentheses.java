package leetcode.easy;

import java.util.Stack;

/**
 * @author youyinnn
 * Date 3/8/2019
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("[][()]({}"));
    }

    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isBegin(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character begin = stack.pop();
                if (!isPair(begin, c)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static boolean isBegin(char a) {
        return a == '(' || a == '[' || a == '{';
    }

    public static boolean isPair(char begin, char end) {
        if (begin == '(') {
            return end == ')';
        } else if (begin == '[') {
            return end == ']';
        } else {
            return end == '}';
        }
    }

}
