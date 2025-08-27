class Solution:
    def maximumSwap(self, num: int) -> int:
        arr = list(str(num))
        right = [-1 for _ in range(10)]

        for i, n in enumerate(arr):
            right[int(n)] = i
        
        for i in range(len(arr)):
            for j in range(9 , int(arr[i]), -1):
                if right[j] > i:

                    arr[i] , arr[right[j]] = arr[right[j]] , arr[i]
                    return int("".join(arr))
        
        return num
