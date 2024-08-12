import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("(()")); // [0,1]
        System.out.println(s.isValid("{[()]}")); // [1,2]
        System.out.println(s.isValid("{[}]()")); // [0,2]
    }

    private static class Solution {

        public boolean isValid(String pars) {
            Stack<Character> S = new Stack<>();
            for (char c : pars.toCharArray()) {
                if (S.empty()) {
                    S.push(c);
                } else {
                    if (S.peek() == '{' && c == '}') {
                        S.pop();
                    }
                    else if (S.peek() == '(' && c == ')') {
                        S.pop();
                    }
                    else if (S.peek() == '[' && c == ']') {
                        S.pop();
                    }
                    else {
                        S.push(c);
                    }
                }
            }
            if (S.empty()) return true;
            return false;
        }

    }
}
