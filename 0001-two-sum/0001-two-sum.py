
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
        return indices of two nums such that they add up to target
        """
        dict = {}
        for i in range(len(nums)):
            if target-nums[i] in dict:
                return [i, dict[target-nums[i]]]
            dict[nums[i]] = i
        return []