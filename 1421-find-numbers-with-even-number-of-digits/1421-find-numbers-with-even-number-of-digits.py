from typing import List


class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        e = 0
        for num in nums:
            d = 0
            while num >= 1:
                num = num / 10
                d += 1
            if d % 2 == 0:
                e += 1
        return e
