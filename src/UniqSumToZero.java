import java.util.Arrays;

// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description/

public class UniqSumToZero {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.sumZero(5)));
        System.out.println(Arrays.toString(s.sumZero(4)));
    }

    private static class Solution {
        public int[] sumZero(int n) {
            int[] ret = new int[n];

            int idx = 0;
            if (n%2 == 1) {
                ret[idx++] = 0;
            }

            for (int i = 1; i <= n/2; i++) {
                ret[idx++] = i;
                ret[idx++] = -i;
            }
            return ret;
        }
    }
}
