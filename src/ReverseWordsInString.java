
// https://leetcode.com/problems/reverse-words-in-a-string/

//   Example 1:
//
//  Input: s = "the sky is blue"
//  Output: "blue is sky the"
//  Example 2:
//
//  Input: s = "  hello world  "
//  Output: "world hello"
//  Explanation: Your reversed string should not contain leading or trailing spaces.
//  Example 3:
//
//  Input: s = "a good   example"
//  Output: "example good a"
//  Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
//


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class ReverseWordsInString {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseWords("the sky is blue"));
    }

    private static class Solution {
        public String reverseWords(String s) {
            s = s.strip();
            String[] ss = s.split("\\s+");
            StringBuilder sb = new StringBuilder();
            for (int i = ss.length-1; i >= 0; i--) {
                sb.append(ss[i]);
                if (i!=0) {
                    sb.append(" ");
                }
            }
            return sb.toString();
        }
    }
}
