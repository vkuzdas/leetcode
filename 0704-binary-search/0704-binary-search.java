class Solution {
        int [] A;
        int t;
        public int search(int[] nums, int target) {
            A = nums;
            t = target;
            return bs(0,A.length-1);
        }

        private int bs(int i, int j) {
            int m = (i+j)/2;
            if (A[m] == t) return m;
            if (i==j)
                return A[i] == t ? i : -1;
            if (j-i == 1)
                if (A[i] == t) return i;
                else if (A[j] == t) return j;
                else return -1;

            if (A[m] > t) {
                return bs(i, m);
            } else if (A[m] < t) {
                return bs(m, j);
            }
            return -1;
        }
}