class Solution:
    def isHappy(self, n: int) -> bool:
        slow = fast = n

        def square(num):
            tot = 0

            while num > 0:
                dig = num%10
                tot += (dig*dig)
                num = num//10

            return tot

        while True:            
            slow = square(slow)
            fast = square(square(fast))
            if slow == fast:
                break
        
        return slow == 1 or fast == 1

