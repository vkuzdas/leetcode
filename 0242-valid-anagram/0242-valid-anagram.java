class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;
            int[] s_freq = new int[26];
            int[] t_freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char s_char = s.charAt(i);
                char t_char = t.charAt(i);
                s_freq[s_char-97]++;
                t_freq[t_char-97]++;
            }
            for (int i = 0; i < s_freq.length; i++) {
                if (s_freq[i] != t_freq[i]) return false;
            }
            return true;
        }
}