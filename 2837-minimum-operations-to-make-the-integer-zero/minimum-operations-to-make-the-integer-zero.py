class Solution:
    def makeTheIntegerZero(self, num1: int, num2: int) -> int:
        for i in range(1, 61):
            # After i operations, the equation becomes:
            # num1 - i * num2 = sum of i powers of two
            val = num1 - i * num2
            # If val < 0, then subtracting too much already → no need to check further
            if val < 0:
                break
            # Key condition:
            # 1. val.bit_count() = minimum number of powers of two needed to represent val
            #    (since binary representation uses exactly 'bitcount' ones).
            # 2. We must use exactly i terms (because each operation contributes one power of two).
            #    So i must be >= bitcount(val).
            # 3. Also, i cannot exceed val (since the maximum number of terms you can split val into is val itself, all 1's).
            if val.bit_count() <= i <= val:
                return i

        return -1
