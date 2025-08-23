class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj = defaultdict(list)
        indegree = [0 for _ in range(numCourses)]

        for a,b in prerequisites:
            adj[b].append(a)
            indegree[a] += 1
        
        q = deque()
        
        for i,course in enumerate(indegree):
            if course == 0:
                q.append(i)
        
        while q:
            course = q.pop()
            numCourses -= 1

            for nei in adj[course]:
                indegree[nei] -= 1

                if indegree[nei] == 0:
                    q.append(nei)
        
        return numCourses == 0
    



        