import java.util.*;

import static java.util.Arrays.asList;

public class ThreeSum {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(s.threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4}));
    }

    /**
     * https://leetcode.com/problems/3sum/description/
     *
     * Given integer array, return all triplets such that they add up to zero
     * Hint: reuse TwoSum problem
     *
     * Fix a number. With this number excluded, do a TwoSum problem.
     */
    private static class Solution {
        // 1) sort for better searching
        // 2) insert into hashmap
        public List<List<Integer>> threeSum(int[] nums) {
            HashSet<List<Integer>> triplets = new HashSet<>();

            for (int i = 0; i < nums.length; i++) {
                int target = - nums[i];
                // create array excluding current num

                int[] cpy = arrCpyExcluding(nums, i);
                int[] tuple = twoSum(cpy, target);
                if(tuple.length != 0) {
                    List<Integer> s = asList(nums[i], tuple[0], tuple[1]);
                    Collections.sort(s);
                    triplets.add(s);
                }
            }
            return triplets.stream().toList();
        }

        private int[] arrCpyExcluding(int[] nums, int idx) {
            int[] cpy = new int[nums.length-1];
            // iterate over all indexes in nums
            // if index equals idx, skip it
            int cpy_last = 0;
            for (int i = 0; i < nums.length; i++) {
                if(i == idx) continue;
                else {
                    cpy[cpy_last++] = nums[i];
                }
            }
            return cpy;
        }


        // return numbers which add up to target
        // empty array otherwise
        public int[] twoSum(int[] nums, int target) {
            HashSet<Integer> set = new HashSet<>();
            // add all numbers to a hashSet
            for(int i : nums) {
                set.add(i);
            }
            // for a number I in array, subtract it from target T
            // now look for integer J=T-I in the hashSet
            for (int j = 0; j < nums.length; j++) {
                int i = nums[j];
                int t = target - i;
                if (set.contains(t) && find(t, nums) != j) {
                    int ti = find(t, nums);
                    if(ti == -1) return new int[]{};
                    return new int[]{nums[j], nums[ti]};
                }
            }
            return new int[]{};
        }

        // return index of target, -1 if not contained
        public int find(int target, int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) return i;
            }
            return -1;
        }
    }
}
