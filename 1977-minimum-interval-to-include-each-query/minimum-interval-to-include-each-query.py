class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:

        org = queries[:]
        m = {}
        n = len(intervals)

        intervals.sort()
        queries.sort()

        pq = []
        i = 0

        for query in queries:
            while i < n and intervals[i][0] <= query:
                heapq.heappush(
                    pq, (intervals[i][1] - intervals[i][0] + 1, intervals[i][1])
                )
                i += 1

            while pq and query > pq[0][1]:
                heapq.heappop(pq)

            m[query] = pq[0][0] if pq else -1

        for i, o in enumerate(org):
            org[i] = m[o]

        return org
