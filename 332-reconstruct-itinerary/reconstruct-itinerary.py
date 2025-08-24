class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        adj = defaultdict(list)

        for src, dest in tickets:
            heapq.heappush(adj[src], dest)
        res = []
        def dfs(src):
            while adj[src]:
                dfs(heapq.heappop(adj[src]))
            res.append(src)
            
        
        dfs("JFK")
        return res[::-1]

        