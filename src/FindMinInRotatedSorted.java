import java.util.Arrays;

public class FindMinInRotatedSorted {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMin(new int[]{3,4,5,6,11,16,99,168,1,2}));
        System.out.println(s.findMin(new int[]{6,11,16,99,168,1,2,3,4,5}));
        System.out.println(s.findMin(new int[]{6,11,16,99,168,2,3,4,5}));
    }

    /**
     * Given a sorted list that has been rotated, find the minimum value in it
     *      - we can use modified binary search for this
     *      - if middle element is lesser than last element, we know the element is in right subarray, left otherwise
     */

    private static class Solution {
        public int findMin(int[] nums) {
            if(nums.length == 2) {
                return Math.min(nums[0], nums[1]);
            }
            int mi = nums.length/2;
            int ri = nums.length-1;
            int m = nums[mi];
            int r = nums[ri];


            if (m > r) {
                int[] arg = Arrays.copyOfRange(nums, mi, nums.length);
                return findMin(arg);
            }
            else if (m < r) {
                int[] arg = Arrays.copyOfRange(nums, 0, mi+1);
                return findMin(arg);
            }
            else { // m==r
                return m;
            }
        }
    }
}
