import java.util.Arrays;

public class SearchInSortedRotated {


    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.findMinIndex(new int[]{3,4,5,6,11,16,99,168,1,2}));
        System.out.println(s.findPivotIndex(new int[]{4,5,6,7,0,1,2}));
        System.out.println(s.findPivotIndex(new int[]{6,11,16,99,168,1,2,3,4,5}));
//        System.out.println(s.findMinIndex(new int[]{6,11,16,99,168,2,3,4,5}));
//        System.out.println(s.findMinIndex(new int[]{6,11,16,1,2,3,4,5}));
//        System.out.println(s.findMinIndex(new int[]{6,11,16,1,2,3,4,5}));
    }

    private static class Solution {
        public int findPivotIndex(int[] nums) {
            if(nums.length == 2) {
                return nums[0] < nums[1] ? 0 : 1;
            }
            int mi = nums.length/2;
            int ri = nums.length-1;
            int m = nums[mi];
            int r = nums[ri];

            if (m > r) {
                int[] arg = Arrays.copyOfRange(nums, mi, nums.length);
                return mi + findPivotIndex(arg);
            }
            else if (m < r) {
                int[] arg = Arrays.copyOfRange(nums, 0, mi+1);
                return findPivotIndex(arg);
            }
            else { // m==r
                return 0;
            }
        }
    }

}
