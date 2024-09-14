class Solution {
public int[] dailyTemperatures(int[] temperatures) {
            int[] ans = new int[temperatures.length];
            Stack<int[]> S = new Stack<>();
            S.push(new int[]{0, temperatures[0]});

            for (int i = 1; i < temperatures.length; i++) {
                while (!S.empty() && S.peek()[1] < temperatures[i]) {
                    ans[S.peek()[0]] = i-S.peek()[0]; // diff of indexes
                    S.pop();
                }
                S.push(new int[]{i, temperatures[i]});
            }
            while (!S.empty()) {
                ans[S.peek()[0]] = 0;
                S.pop();
            }
            return ans;
        }
}