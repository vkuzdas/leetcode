import heapq
from typing import Counter, List

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        pq = []
        c = Counter(nums)
        for num, freq in c.items():
            heapq.heappush(pq, (-freq, num))
        r = list()
        for i in range(k):
            r.append(heapq.heappop(pq)[1])
        return r

