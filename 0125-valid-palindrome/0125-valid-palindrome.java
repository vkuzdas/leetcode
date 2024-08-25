class Solution {
        public boolean isPalindrome(String s) {
            StringBuilder stripped_sb = new StringBuilder();
            StringBuilder reversed_sb = new StringBuilder();
            for(char c : s.toCharArray()) {
                if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                    c = Character.toLowerCase(c);
                    stripped_sb.insert(stripped_sb.length(), c); // append
                    reversed_sb.insert(0, c); // prepend
                }
            }
            return stripped_sb.toString().equals(reversed_sb.toString());
        }
}