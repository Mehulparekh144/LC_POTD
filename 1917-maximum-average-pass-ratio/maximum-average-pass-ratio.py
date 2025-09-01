class Solution:
    def maxAverageRatio(self, classes: List[List[int]], extraStudents: int) -> float:
        pq = []

        for p, t in classes:
            gain = ((p+1)/(t+1)) - p/t
            heapq.heappush(pq, (-gain , p , t))
        
        while extraStudents:
            neg_gain, p , t = heapq.heappop(pq)

            p += 1
            t += 1

            new_gain = ((p+1)/(t+1)) - p/t
            heapq.heappush(pq, (-new_gain , p , t))
            extraStudents -= 1
        
        total = 0

        while pq:
            neg_gain, p , t = heapq.heappop(pq)
            total += (p/t)
        
        return total/len(classes)
