class TimeMap:

    def __init__(self):
        self.m = {}
        

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.m:
            self.m[key] = [(value, timestamp)]
        else:
            self.m[key].append((value, timestamp))
        

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.m:
            return ""
        
        lst = self.m[key]

        l = 0
        r = len(lst) - 1

        while l <= r:
            mid = l + (r-l)//2

            value, time = lst[mid]

            if time == timestamp:
                return value
            elif time < timestamp:
                l = mid + 1
            else:
                r = mid - 1
        
        return "" if r < 0 else lst[r][0]
        


# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)