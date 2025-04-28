class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        """
        Given two strings s and t, 
        return true if t is an anagram of s, and false otherwise.
        """
        if len(s) != len(t):
            return False
        dict1 = {}
        dict2 = {}
        for i in range(0, len(s)):
            if s[i] in dict1:
                dict1[s[i]] = dict1[s[i]] + 1
            else:
                dict1[s[i]] = 1

            if t[i] in dict2:
                dict2[t[i]] = dict2[t[i]] + 1
            else:
                dict2[t[i]] = 1

        return dict1 == dict2