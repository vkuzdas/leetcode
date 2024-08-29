class Solution {
        public boolean isPalindrome(String s) {
            int i = 0;
            int j = s.length()-1;
            while (i < j && i < s.length()-1 && j > 0) {
                while (!(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))) && i < s.length()-1) {
                    i++;
                }
                while (!(Character.isAlphabetic(s.charAt(j)) || Character.isDigit(s.charAt(j))) && j > 0) {
                    j--;
                }
                char ci = s.charAt(i);
                char cj = s.charAt(j);
                if (i>j) return true;
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
}