import java.util.Arrays;
import java.util.stream.Stream;

public class SearchInSortedRotated {


    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.findPivotIndex(new int[]{4,5,6,7,0,1,2}));
//        System.out.println(s.search(new int[]{6,11,16,99,168,1,2,3,4,5}, 99));
//        System.out.println(s.search(new int[]{6,11,16,99,168,1,2,3,4,5}, 16));
//        System.out.println(s.search(new int[]{6,11,16,99,168,1,2,3,4,5}, 6));
//        System.out.println(s.search(new int[]{6,11,16,99,168,1,2,3,4,5}, 4));
//        System.out.println(s.search(new int[]{6,11,16,99,168,1,2,3,4,5}, 4));
//        System.out.println(s.search(new int[]{6,11,16,99,168,1,2,3,4}, 4));
//        System.out.println(s.search(new int[]{6,11,16,99,168,1,2,3,4}, 1));
//        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 0));
//        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 3));
//        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 3));
//        System.out.println(s.search(new int[]{3,5,1}, 5));
        System.out.println(s.search(new int[]{5,1,3}, 2));
    }


    /**
     * Given sorted, then rotated array return the
     * index of searched target. Return -1 if not present.
     *
     * 1) Find the pivot value by doing binary search
     * 2) do binary search again, now informed about the pivot position:
     *      - if target > pivot and target <= arr[last], target should be contained in the right subarray
     */
    private static class Solution {

        public int search(int[] nums, int target) {
            int pi = findPivotIndex(nums);
            int p = nums[pi];
            if (target == nums[pi]) return pi;
            if (target == nums[0]) return 0;
            if (target == nums[nums.length-1]) return nums.length-1;

            if(target > p && target <= nums[nums.length-1]) {
                // t is in right side
                int i = binSearch(Arrays.copyOfRange(nums, pi, nums.length), target);
                if (i==-1) return -1;
                return pi + i;
            }
            else {
                // t is in left side
                return binSearch(Arrays.copyOfRange(nums, 0, pi+1), target);
            }

        }

        private int binSearch(int[] ints, int t) {
            if (ints.length == 0) return -1;
            if(ints.length == 1) {
                if(t == ints[0]) return 0;
                else return -1;
            }
            if(ints.length == 2){
                if (t != ints[0] || t != ints[1]){ // not first or second
                    return -1;
                }
                else { // else it is present at least
                    return t == ints[0] ? ints[0] : ints[1];
                }
            }

            int mi = ints.length/2;
            int m = ints[mi];

            if(m == t) {
                return mi;
            }

            if(t > m) {
                int i = binSearch(Arrays.copyOfRange(ints, mi, ints.length), t);
                if (i == -1) return -1;
                return mi + i;
            } else {
                int i = binSearch(Arrays.copyOfRange(ints, 0, mi + 1), t);
                if (i == -1) return -1;
                return i;
            }

        }

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
