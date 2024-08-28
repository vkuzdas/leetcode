class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            // 1) two frequency hashmaps

            // 2) one frequency hashmap for magazine, decrease it for each letter in ransom
            //      if there is a cell in hashmap less than zero, return false
            HashMap<Character, Integer> frequency = new HashMap<>();

            for(char c : magazine.toCharArray()) {
                if (!frequency.containsKey(c)) {
                    frequency.put(c, 1);
                } else {
                    frequency.put(c, frequency.get(c)+1);
                }
            }

            for(char c : ransomNote.toCharArray()) {
                if (!frequency.containsKey(c)) {
                    return false;
                } else {
                    int val = frequency.get(c);
                    if (val == 0) return false;
                    frequency.put(c, val-1);
                }
            }

            for (int val : frequency.values()) {
                if(val < 0) return false;
            }
            return true;
        }
}