class Solution {
    public int maxDepth(String s) {
        // if closing, pop
        // if opening, push
        Stack<Character> S = new Stack<>();
        int maxDepth = 0;
        for(char c : s.toCharArray()) {

            if(c == '(') {
                S.push(c);
                maxDepth = Math.max(maxDepth, S.size());
            }
            else if(c == ')') {
                S.pop();
            }

        }
        return maxDepth;

    }
}