class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            ArrayList<int[]> result = new ArrayList<>();

            int i = 0;
            while (i < intervals.length && intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
                i++;
            }
            while (i < intervals.length && !(newInterval[1] < intervals[i][0])) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
            result.add(newInterval);

            while (i < intervals.length) {
                result.add(intervals[i]);
                i++;
            }

            int [][] RES = new int[result.size()][2];
            for (int j = 0; j < result.size(); j++) {
                RES[j] = result.get(j);
            }
            return RES;

            // 1) add intervals before new  (intervals[i][1] < newInterval[0])
            // 2) merge all intervals touching newInterval (all intervals that are not before and: intrervals[i][1] < newInterval[1])

            // 3) add all intervals after new
        }
}