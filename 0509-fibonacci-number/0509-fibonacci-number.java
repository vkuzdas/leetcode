class Solution {
        public int fib(int n) {
            int[] d = new int[]{0,1};
            for (int i = 0; i < n-1; i++) {
                d[i%2] = d[i%2] + d[(i+1)%2];
            }
            return d[n%2];
        }
}