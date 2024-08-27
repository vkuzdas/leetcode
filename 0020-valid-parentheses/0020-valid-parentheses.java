class Solution {
        public boolean isValid(String s) {
            Stack<Character> S = new Stack<>();
            for(char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    S.push(c);
                }
                else if (c == ')' ||c == '}' ||c == ']') {
                    if (S.empty()) return false;
                    char top = S.peek();
                    if (top == '(' && c == ')')
                        S.pop();
                    else if (top == '[' && c == ']')
                        S.pop();
                    else if (top == '{' && c == '}')
                        S.pop();
                    else 
                        return false;
                }
            }
            if (S.empty())
                return true;
            return false;
        }
}