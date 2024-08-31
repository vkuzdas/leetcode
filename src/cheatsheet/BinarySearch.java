package cheatsheet;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        int m = i+(j-i)/2; // prevent overflow

        if (target == nums[m]) {
            return m;
        }
        else if (target > nums[m]) {
            return bs(m, j, nums, target);
        }
        else /*if (target < nums[m])*/ {
            return bs(i, m, nums, target);
        }
    }

    private int bs(int i, int j, int[] nums, int target) {
        if (j == i) {
            return target == nums[i] ? i : -1;
        }
        if (j-i == 1) {
            if (nums[j] == target) {
                return j;
            } else if (nums[i] == target) {
                return i;
            } else {
                return -1;
            }
        }

        int m = i+(j-i)/2;
        if (target == nums[m]) {
            return m;
        }
        else if (target > nums[m]) {
            return bs(m, j, nums, target);
        }
        else /*if (target < nums[m])*/ {
            return bs(i, m, nums, target);
        }
    }
}
