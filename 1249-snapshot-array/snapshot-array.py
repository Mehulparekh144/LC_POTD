class SnapshotArray:

    def __init__(self, length: int):
        self.m = [[(0,0)] for _ in range(length)]
        self.s = 0

    def set(self, index: int, val: int) -> None:
        self.m[index].append((self.s , val))

    def snap(self) -> int:
        self.s += 1
        return self.s - 1

    def get(self, index: int, snap_id: int) -> int:
        li = self.m[index]

        l = 0 
        r = len(li) - 1
        res = 0

        while l <= r:
            m = l + (r-l)//2
            snap , val = li[m]

            if snap <= snap_id:
                res = val
                l = m + 1
            else:
                r = m - 1
        
        return res
        


# Your SnapshotArray object will be instantiated and called as such:
# obj = SnapshotArray(length)
# obj.set(index,val)
# param_2 = obj.snap()
# param_3 = obj.get(index,snap_id)