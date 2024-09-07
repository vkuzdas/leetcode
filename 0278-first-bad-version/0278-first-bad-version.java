/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int i = 1;
            int j = n;
            int m = i+(j-i)/2;
            if (isBadVersion(m)) {
                return bs(i, m);
            }
            else {
                return bs(m, j);
            }
        }

        private int bs(int i, int j) {
            if (j-i <=1) {
                if (isBadVersion(i)) return i;
                if (isBadVersion(j)) return j;
            }

            int m = i+(j-i)/2;
            if (isBadVersion(m)) {
                return bs(i, m);
            }
            else {
                return bs(m, j);
            }
        }
}