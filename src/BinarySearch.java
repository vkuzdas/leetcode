public class BinarySearch {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.search(new int[]{-1,0,3,5,9,12}, 4);
    }

    private static class Solution {
        public int search(int[] A, int T) {
            int i = 0;
            int j = A.length-1;
            return binSearch(A, T, i, j);
        }

        private int binSearch(int[] A, int T, int i, int j) {
            if (j - i == 0)
                if (A[i] == T)
                    return i;
                else return -1;

            if (j - i == 1)
                if (A[i] == T || A[j] == T)
                    return (A[i]==T) ? i : j;
                else
                    return -1;

            int m = (i+j)/2;
            if (A[m] == T)
                return m;
            if (A[m] < T)
                return binSearch(A,T,m,j);
            else if (A[m] > T)
                return binSearch(A,T,i,m);

            return -1;
        }
    }

//    int search(int[] A, int T)
//    i = 0
//    j = A.len-1
//    res = binSearch(A, T, i, j)
//    return res;
//
//    int binSearch(A, T, i, j)
//    if (i - j) == 0
//            if A[i] == T


//            return i
//        else
//                return -1
//                if (i - j) == 1
//            if A[i] == T || A[j] == T
//            return (A[j]==T) ? j : i
//        else
//                return -1
//
//    m = (i + j) / 2
//            if A[m] == T
//        return m
//    if A[m] < T   // use A[m:j]
//        return binSearch(A, T, m, j)
//    elif A[m] > T  // use A[i:m]
//        return binSearch(A, T, i, m)

}
