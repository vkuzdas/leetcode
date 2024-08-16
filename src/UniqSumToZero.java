import java.util.Arrays;

public class UniqSumToZero {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.sumZero(4)));
    }

    private static class Solution {
        // Given an integer n, return any array containing n unique integers such that they add up to 0.
        // vygeneruj uniq integery ktere sumuji do 0
        public int[] sumZero(int n) {
            // pokud liche, pridej nulu
            // pokud sude, iteruj do n/2 a to same dej i zaporne
            int[] arr = new int[n];
            int i = 0;
            if (n % 2 != 0) {
                arr[i++] = 0;
            }
            for (int j = i; j < n/2; j++) {
                arr[i++] = i;
            }
            for (int j = i; j < n/2; j++) {
                arr[i++] = -i;
            }
            return arr;
        }
    }

}
