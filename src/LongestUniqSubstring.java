import java.util.HashSet;
import java.util.Hashtable;

public class LongestUniqSubstring {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(s.lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(s.lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(s.lengthOfLongestSubstring("tmmzuxt")); // 5
        System.out.println(s.lengthOfLongestSubstring("umvejcuuk")); // 6
        System.out.println(s.lengthOfLongestSubstring("gaaqfeqlqky")); // 4
    }

    // have two pointers
    //   f_ptr = new char to include
    //   s_ptr = last char to include
    //
    // shift f_ptr on each iteration, try to insert it's char to HT
    // if HT already contains its char, keep shifting s_ptr to the right
    private static class Solution {
        public int lengthOfLongestSubstring(String str) {
            HashSet<Character> set = new HashSet<>();
            int f_ptr = 0;
            int s_ptr = 0;
            int max = 0;

            while (f_ptr < str.length()) {
                char f_char = str.charAt(f_ptr);
                char s_char = str.charAt(s_ptr);

                while(set.contains(f_char)) {
                    set.remove(s_char);
                    s_ptr++;
                    s_char = str.charAt(s_ptr);
                }

                set.add(f_char);
                max = Math.max(max, set.size());

                f_ptr++;
            }
            return max;
        }
    }
}
