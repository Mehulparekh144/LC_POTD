class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        n = len(speed)
        pair = []

        for i in range(n):
            pair.append(
                [target - position[i] , speed[i]]
            )
        
        pair.sort(key=lambda x:x[0])


        st = []
        st.append(
            pair[0][0]/pair[0][1]
        )

        for i in range(1,n):
            time = pair[i][0]/pair[i][1]

            if time > st[-1]:
                st.append(time)
        
        return len(st)