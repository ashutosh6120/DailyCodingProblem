// This problem was asked by Facebook.

// Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

// For example, given the string "([])", you should return true.

// Given the string "([)]" or "((()", you should return false.


import java.util.Deque;
import java.util.LinkedList;


class Problem27 {

    public static void main(String... args) {
        System.out.println(isBalanced("([])[]({})"));   // true
        System.out.println(isBalanced("([)]"));   // false
    }

    public static boolean isBalanced(String str) {
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            else {
                if (stack.isEmpty())
                    return false;

                char prv = stack.pop();

                if (prv == '(' && ch != ')')
                    return false;
                if (prv == '[' && ch != ']')
                    return false;
                if (prv == '{' && ch != '}')
                    return false;
            }
        }

        return stack.isEmpty();
    }
}