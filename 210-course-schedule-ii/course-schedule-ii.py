class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:

        adj = defaultdict(list)
        indegree = [0 for _ in range(numCourses)]
        res = []

        for a,b in prerequisites:
            adj[b].append(a)
            indegree[a] += 1
        
        q = deque()

        for i, course in enumerate(indegree):
            if course == 0:
                q.append(i)
        
        while q:
            course = q.pop()
            numCourses -= 1
            res.append(course)

            for nei in adj[course]:
                indegree[nei] -= 1

                if indegree[nei] == 0:
                    q.append(nei)
        
        return [] if numCourses else res