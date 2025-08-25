class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        q = deque()
        n = len(nums)
        res = []

        for i in range(n):

            while q and i-k >= q[0]:
                q.popleft()
            
            while q and nums[i] >= nums[q[-1]]:
                q.pop()
            
            q.append(i)

            if i+1 >= k:
                res.append(nums[q[0]])
        
        return res