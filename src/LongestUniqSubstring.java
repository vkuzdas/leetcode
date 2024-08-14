import java.util.Hashtable;

public class LongestUniqSubstring {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(s.lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(s.lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(s.lengthOfLongestSubstring("tmmzuxt")); // 5
    }

    private static class Solution {
        public int lengthOfLongestSubstring(String str) {
            Hashtable<Character, Integer> ht = new Hashtable<>();
            int f = 0;
            int s = 0;
            int max = 0;
            while (f != str.length()) {
                char c = str.charAt(f);
                if (ht.containsKey(c)) {
                    if (str.charAt(s) == c) {
                        s++;
                        ht.put(c, f);
                        max = Math.max(max, f-s+1);
                    }
                    else {
                        s = ht.get(c) + 1;
                        int finalS = s;
                        ht.entrySet().removeIf(kv -> kv.getValue() < finalS && kv.getKey() != c);
                    }
                }
                else {
                    ht.put(c, f);
                    max = Math.max(max, f-s+1);
                }
                f++;
            }
            return max;
        }
    }
}
