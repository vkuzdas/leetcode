from typing import Counter


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        """
        Given two strings s and t, 
        return true if t is an anagram of s, and false otherwise.
        """
        dict1 = Counter(s)
        dict2 = Counter(t)
        return dict1 == dict2