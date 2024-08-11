//https://leetcode.com/problems/sign-of-the-product-of-an-array/description/

public class SignOfProduct {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.arraySign(new int[]{-1,-2,-3,-4,3,2,1});
    }

    static class Solution {
        public int arraySign(int[] nums) {
            int neg = 0;
            for (int i : nums) {
                if (i==0) return 0;
                else if (i < 0) neg++;
            }
            if (neg % 2 == 0) return 1;
            else return -1;
        }
    }
}


