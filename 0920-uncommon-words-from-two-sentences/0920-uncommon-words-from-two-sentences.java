class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] words1 = s1.split("\s");
        String[] words2 = s2.split("\s");
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (String word : words1) {
            if (map1.containsKey(word))
                map1.put(word, map1.get(word)+1);
            else 
                map1.put(word,1);
        }
        for (String word : words2) {
            if (map2.containsKey(word))
                map2.put(word, map2.get(word)+1);
            else
                map2.put(word,1);
        }
        ArrayList<String> words = new ArrayList<>();
        map1.forEach((word, freq) -> {
            if(freq == 1 && !map2.containsKey(word)) {
                words.add(word);
            }
        });
        map2.forEach((word, freq) -> {
            if(freq == 1 && !map1.containsKey(word)) {
                words.add(word);
            }
        });
        
        
        String[] result = new String[words.size()];
        for (int i = 0; i < words.size(); i++) {
            result[i] = words.get(i);
        }
        return result;
    }
}