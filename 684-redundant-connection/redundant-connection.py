class DSU:

    def __init__(self , n):
        self.size = [1 for _ in range(n)]
        self.parent = [i for i in range(n)]
    
    def find(self, node):
        if self.parent[node] != node:
            self.parent[node] = self.find(self.parent[node])
        
        return self.parent[node]
    
    def union(self, u , v):
        pu = self.find(u)
        pv = self.find(v)

        if pu == pv: return

        sizeu = self.size[pu]
        sizev = self.size[pv]

        if sizeu > sizev:
            self.size[pu] = sizeu + sizev
            self.parent[pv] = pu
        else:
            self.size[pv] = sizeu + sizev
            self.parent[pu] = pv  

class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        dsu = DSU(n+1)

        ans = []

        for u,v in edges:
            if dsu.find(u) == dsu.find(v):
                ans = [u,v]
            else:
                dsu.union(u,v)
        
        return ans