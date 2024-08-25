import java.util.Stack;
class Solution {
                    public boolean isValid(String s) {
            Stack<Character> S = new Stack<>();
            for(char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    S.push(c);
                }
                else {
                    char top = S.peek();
                    if (matches(top, c)) {
                        S.pop();
                    }
                    else {
                        return false;
                    }
                }
            }
            if (!S.empty()) {
                return false;
            }
            return true;
        }

        private boolean matches(char o, char c) {
            if (o == '(' && c == ')') return true;
            if (o == '{' && c == '}') return true;
            if (o == '[' && c == ']') return true;
            return false;
        }
}