class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        HT = {}
        for str in strs:
            s = ''.join(sorted(str))
            if s in HT:
                HT[s].append(str)
            else:
                HT[s] = [str]
        l = list()
        for k,v in HT.items():
            l.append(list(v))
        return l
        