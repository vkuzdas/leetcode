import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class PalindromePartition {
    // s = "aaab"
    // output = [["a","a","a","b"],["a","aa","b"],["aa","a","b"],["aaa","b"]]
    //
    // s = "abcaa"
    // output = [["a","b","c","a","a"],["a","b","c","aa"]]
    //
    // s = "abbab"
    // output = [["a","b","b","a","b"],["a","b","bab"],["a","bb","a","b"],["abba","b"]]
    //
    // s = "abaca"
    // output = [["a","b","a","c","a"],["a","b","aca"],["aba","c","a"]]
    //
    // s = "aaa"
    // output = [["a","a","a"],["a","aa"],["aa","a"],["aaa"]]

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.partition("abbab"));
    }

    private static class Solution {
        public List<List<String>> partition(String s) {
            // let L = s.length
            // call recursive DFS L-times for each substring s[0:1], s[0:2], s[0:3] ...
            // each successive call of DFS will try to expand the current string by 1,2,3.. chars and call DFS again

            List<List<String>> res = new ArrayList<>();

            ArrayList<String> rootSubstrings = new ArrayList<>();
            for (int i = 1; i <= s.length(); i++) {
                String substr = s.substring(0,i);
                if(isPalindrome(substr)) {
                    rootSubstrings.add(substr);
                }
            }

            for(String str : rootSubstrings) {
                ArrayList<String> path = new ArrayList<>();
                path.add(str);
                dfs(path, str, s, res);
            }

            return res;
        }

        private void dfs(ArrayList<String> path, String used, String s, List<List<String>> res) {
            // breaking condition: all chars from s have been used -> path includes all palindromes
            if(s.equals(used)) {
                res.add(path);
                return;
            }

            // try expanding
            List<String> substrings = new ArrayList<>();
            for (int i = used.length(); i <= s.length(); i++) {
                String substr = s.substring(used.length(), i);
                if (isPalindrome(substr)) {
                    substrings.add(substr);
                }
            }

            // each pal substr is inputed into dfs, searched again
            for (String substr : substrings) {
                ArrayList<String> newPath = new ArrayList<>(path);
                newPath.add(substr);
                dfs(newPath, used.concat(substr), s, res);
            }
        }

        private boolean isPalindrome(String s) {
            if(s.isEmpty()) return false;
            String rev = new StringBuilder(s).reverse().toString();
            return s.equals(rev);
        }
    }







}
