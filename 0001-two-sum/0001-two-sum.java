import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] A, int T) {
        HashMap<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i <= A.length-1; i++) {
            valueToIndex.put(A[i], i);
        }

        for (int i = 0; i <= A.length-1; i++) {
            int i_val = A[i];
            int j_val = T - i_val;
            if (valueToIndex.containsKey(j_val) && valueToIndex.get(j_val) != i) {
                return new int[]{i, valueToIndex.get(j_val)};
            }
        }
        return new int[]{};
    }
}