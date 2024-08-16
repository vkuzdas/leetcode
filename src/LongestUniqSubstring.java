import java.util.Hashtable;

public class LongestUniqSubstring {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.lengthOfLongestSubstring("abcabcbb")); // 3
//        System.out.println(s.lengthOfLongestSubstring("bbbbb")); // 1
//        System.out.println(s.lengthOfLongestSubstring("pwwkew")); // 3
//        System.out.println(s.lengthOfLongestSubstring("tmmzuxt")); // 5
//        System.out.println(s.lengthOfLongestSubstring("umvejcuuk")); // 6
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

        }
    }
}
