class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
        return indices of two nums such that they add up to target
        """
        dict = {}
        for i in range(len(nums)):
            dict[nums[i]] = i # key=number, value=index
        for i in range(len(nums)):
            diff = target - nums[i]
            if diff in dict and dict[diff] != i:
                return [i, dict[diff]]
        return []
    