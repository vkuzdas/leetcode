class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> result = new ArrayList<>();

            // for all before newInterval
            int i = 0;
            while (i < intervals.length && intervals[i][1] < newInterval[0]) { // end less than start
                result.add(intervals[i]);
                i++;
            }

            // for all that touch newInterval
            while (i < intervals.length && intervals[i][0] <= newInterval[1]) { // for all with len until new END
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                i++;
            }
            result.add(newInterval);

            // for all the rest
            while (i < intervals.length) {
                result.add(intervals[i]);
                i++;
            }

            return result.toArray(new int[result.size()][]);
        }
}