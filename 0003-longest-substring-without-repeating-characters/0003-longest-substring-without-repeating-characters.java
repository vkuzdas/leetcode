class Solution {
        public int lengthOfLongestSubstring(String s) {
            int max = 0;
            HashSet<Character> set = new HashSet<>();
            int slow = 0;
            for (int f = 0; f < s.length(); f++) {
                while (set.contains(s.charAt(f))) {
                    set.remove(s.charAt(slow));
                    slow++;
                }
                set.add(s.charAt(f));
                max = Math.max(max, set.size());
            }
            return max;
        }
}