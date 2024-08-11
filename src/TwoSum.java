//https://leetcode.com/problems/two-sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class TwoSum {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.twoSum(new int[]{2, 7, 11, 15}, 9))); // [0,1]
        System.out.println(Arrays.toString(s.twoSum(new int[]{3,2,4}, 6))); // [1,2]
        System.out.println(Arrays.toString(s.twoSum(new int[]{3,2,3}, 6))); // [0,2]
    }
    private static class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashSet<Integer> set = new HashSet<>();
            for(int i : nums) {
                set.add(i);
            }
            for (int j = 0; j < nums.length; j++) {
                int i = nums[j];
                int t = target - i;
                if (set.contains(t) && find(t, nums) != j) {
                    return new int[]{j, find(t, nums)};
                }
            }
            return new int[]{0,1};
        }

        public int find(int target, int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) return i;
            }
            return -1;
        }
    }
}


