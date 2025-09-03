class Solution:
    def numberOfPairs(self, points: List[List[int]]) -> int:
        points.sort(key=lambda p:(p[0] , -p[1]))

        count = 0

        for i, (x1, y1) in enumerate(points):
            b = float('-inf') #max bob seen so far

            for _, (x2, y2) in enumerate(points[i+1:]):
                if y1 >= y2:
                    if y2 > b:
                        count += 1
                        b = y2
        
        return count