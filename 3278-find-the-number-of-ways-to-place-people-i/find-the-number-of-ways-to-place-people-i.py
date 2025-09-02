class Solution:
    def numberOfPairs(self, points: List[List[int]]) -> int:
        n = len(points)
        count = 0

        for i in range(n):
            x1, y1 = points[i]

            for j in range(n):
                if i == j: 
                    continue
                x2, y2 = points[j]

                if x1 <= x2 and y1 >= y2:
                    isValid = True

                    for k in range(n):
                        if k == i or k == j: continue

                        x,y = points[k]

                        if x1 <= x <= x2 and y2 <= y <= y1:
                            isValid = False
                            break
                        
                    
                    if isValid:
                        count += 1
        
        return count


        