/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return bs(0,n);
    }

    private int bs(int i, int j) {
        if (i==j) {
            return j;
        }
        if (j-i == 1) {
            return isBadVersion(j) ? j : i;
        }
        int m = i+(j-i)/2; // use this to prevent overflow!!!
        if (isBadVersion(m)) {
            return bs(i, m);
        }
        else return bs(m, j);
    }
}