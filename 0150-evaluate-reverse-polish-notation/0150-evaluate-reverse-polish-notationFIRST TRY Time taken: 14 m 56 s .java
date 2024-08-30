class Solution {
        public int evalRPN(String[] tokens) {
            Stack<String> S = new Stack<>();

            for (int i = 0; i < tokens.length; i++) {
                if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/") || tokens[i].equals("*")) {
                    int op2 = Integer.parseInt(S.pop());
                    int op1 = Integer.parseInt(S.pop());
                    int res = 0;
                    if (tokens[i].equals("+")) res = op1 + op2;
                    if (tokens[i].equals("-")) res = op1 - op2;
                    if (tokens[i].equals("*")) res = op1 * op2;
                    if (tokens[i].equals("/")) res = op1 / op2;
                    S.push(""+res);
                } else {
                    S.push(tokens[i]);
                }
            }
            return Integer.parseInt(S.pop());
        }
}