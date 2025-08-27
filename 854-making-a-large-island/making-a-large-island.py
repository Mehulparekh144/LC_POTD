class DSU:
    
    def __init__(self, n):
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
    def largestIsland(self, grid: List[List[int]]) -> int:
        n = len(grid)
        dsu = DSU(n*n)

        dirs = [(0,1) , (0,-1) , (1,0) , (-1,0)]

        for i in range(n):
            for j in range(n):
                if grid[i][j] == 0:
                    continue

                for dx,dy in dirs:
                    i1 = i + dx
                    j1 = j + dy

                    if i1 < 0 or j1 < 0 or i1 >= n or j1 >= n or grid[i1][j1] == 0:
                        continue
                    
                    u = i1 * n + j1
                    v = i*n + j

                    dsu.union(u, v)
        
        maxi = 0
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    continue
                components = set()
                
                for dx,dy in dirs:
                    i1 = i + dx
                    j1 = j + dy

                    if i1 < 0 or j1 < 0 or i1 >= n or j1 >= n or grid[i1][j1] == 0:
                        continue
                    
                    
                    components.add(dsu.find(i1*n + j1))
                
                size = 1
                for one in components:
                    size += dsu.size[one]
                maxi = max(size, maxi)
        
        for i in range(n*n):
            maxi = max(maxi, dsu.size[i])

        return maxi

                


