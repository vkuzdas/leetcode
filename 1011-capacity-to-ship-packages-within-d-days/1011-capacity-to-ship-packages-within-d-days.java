class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            max = Math.max(weights[i], max);
            sum += weights[i];
        }

        int l = max;
        int r = sum;
        int ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int calcDays = calcDays(m, weights);
            if (calcDays == days) {
                ans = m;
                r = m - 1;
            } else if (calcDays < days) {
                r = m - 1; // left, decrease capacity, increase days
            } else if (calcDays > days) {
                l = m + 1; // right, increase capacity, decrease days
            }
        }
        return ans;
    }

    public int calcDays(int capacity, int[] weights) {
        int days = 0;
        int load = 0;
        for (int i = 0; i < weights.length; i++) {
            load += weights[i];
            if (load > capacity) {
                days++;
                load = weights[i];
            }
        }
        days++;
        return days;
    }
}