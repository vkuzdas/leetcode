import java.util.*;
import java.util.stream.Stream;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    // insert all strings into a hashtable, where:
    //      - value is the string itself
    //      - key is the sorted string
    private static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, ArrayList<String>> table = new HashMap<>();

            for(String str : strs) {
                String value = str;
                char[] arr = str.toCharArray();
                Arrays.sort(arr);
                String key = Arrays.toString(arr);
                if(!table.containsKey(key)) {
                    table.put(key, new ArrayList<>());
                }
                table.get(key).add(value);
            }

            List<List<String>> ret = new ArrayList<>(table.values());


            return ret;
        }
    }
}
