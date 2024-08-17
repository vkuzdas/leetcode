import java.util.Arrays;

public class TwoSum2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.twoSum(new int[]{2, 7, 11, 15}, 9)));
//        System.out.println(Arrays.toString(s.twoSum(new int[]{2,3,4}, 6)));
//        System.out.println(Arrays.toString(s.twoSum(new int[]{-1,0}, -1)));
//        System.out.println(Arrays.toString(s.twoSum(new int[]{1,2,3,4,4,9,56,90}, 8)));
    }

    /**
     * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
     * Given sorted array and target, return positions of numbers that add up to the target.
     * You are only allowed to use constant space.
     * -> if you were to use hashset, you would use O(n) space!
     *    ->> use binary search
     * for each number c, calculate f=t-c
     *      then look for the f in the array using binary search
     *      if f > c, then f is in num[c:len]
     *      elif f < c, then f is in num[0:c]
     */
    private static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            for (int i = 0; i < numbers.length; i++) {
                int num = numbers[i];
                int f = target - num;
                int r = Arrays.binarySearch(numbers, f);
                if (r >= 0 && r < numbers.length && r != i) {
                    return new int[]{Math.min(i+1, r+1), Math.max(r+1, i+1)};
                }
            }
            return new int[]{};
        }
    }
}
