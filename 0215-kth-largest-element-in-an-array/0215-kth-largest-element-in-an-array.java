class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < nums.length; i++) {
                pq.add(-nums[i]);
            }
            for (int i = 0; i < k-1; i++) {
                pq.poll();
            }
            int res = -pq.poll();
            return res;
        }
}