class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        st,end = newInterval
        res = []
        n = len(intervals)
        i = 0

        while i < n and intervals[i][1] < st:
            res.append(intervals[i])
            i += 1

        while i < n and intervals[i][0] <= end:
            st = min(intervals[i][0] , st)
            end = max(intervals[i][1] , end)
            i += 1

        res.append([st, end])

        while i < n:
            res.append(intervals[i])
            i += 1
        
        return res
        