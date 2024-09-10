class Solution {
        char[] word;
        String longest = "";
        public String longestPalindrome(String str) {
            if (str.length() == 1) {
                return str.substring(0,1);
            }
            word = str.toCharArray();
            longest = str.substring(0,1);
            int max = 0;
            for (int i = 0; i < str.length(); i++) {
                for (int j = i; j <= i+1 && j < str.length()  ; j++) {
                    int[] s = new int[]{i};
                    int[] e = new int[]{j};
                    if (word[e[0]] != word[s[0]]) continue;
                    if (max < e[0]-s[0]) {
                        max = e[0]-s[0];
                        longest = str.substring(s[0],e[0]+1);
                    }
                    while (expandable(s, e)) {
                        if (max < e[0]-s[0]) {
                            max = e[0]-s[0];
                            longest = str.substring(s[0],e[0]+1);
                        }
                    }
                }
            }
            return longest;
        }

        private boolean expandable(int[] s, int[] e) {
            if (s[0] > 0 && e[0] < word.length-1 &&
                    word[s[0]-1] == word[e[0]+1]) {
                s[0]--;
                e[0]++;
                return true;
            }
            else {
                return false;
            }
        }
}