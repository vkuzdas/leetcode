class Solution {
        public int lengthOfLongestSubstring(String str) {
            HashSet<Character> set = new HashSet<>();
            int max = 0;
            int s = 0;
            for (int f = 0; f < str.length(); f++) {
                while (set.contains(str.charAt(f))) {
                    set.remove(str.charAt(s));
                    s++;
                }
                set.add(str.charAt(f));
                max = Math.max(max, set.size());
            }
            return max;
        }
}