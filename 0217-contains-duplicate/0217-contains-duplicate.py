class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        '''
        Given an integer array nums, 
        return true if any value appears at least 
        twice in the array, 
        return false if every element is distinct.
        '''
        # create hashset
        # go over input numbers
        # see if number is in set
        # if in set return false
        hs = set()
        for num in nums:
            if num not in hs:
                hs.add(num)
            else:
                return True
        return False