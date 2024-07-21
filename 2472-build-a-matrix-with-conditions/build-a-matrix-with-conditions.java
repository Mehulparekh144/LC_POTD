class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<List<Integer>> rowAdj = new ArrayList<>();
        List<List<Integer>> colAdj = new ArrayList<>();

        for(int i = 0 ; i <= k ; i++){
          rowAdj.add(new ArrayList<>());
          colAdj.add(new ArrayList<>());
        }

        int[] rowIn = new int[k+1];
        rowIn[0] = -1;
        int[] colIn = new int[k+1];
        colIn[0] = -1;

        for(int[] row : rowConditions){
          rowAdj.get(row[0]).add(row[1]);
          rowIn[row[1]]++;
        }

        for(int[] col : colConditions){
          colAdj.get(col[0]).add(col[1]);
          colIn[col[1]]++;
        }

        List<Integer> rowSort = topo(rowAdj , rowIn , k);
        List<Integer> colSort = topo(colAdj , colIn , k);
        if(rowSort.size() != k || colSort.size() != k){
          return new int[][]{};
        }

        int[][] res = new int[k][k];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < rowSort.size() ; i++){
          map.put(colSort.get(i) , i);
        }

        for(int i = 0 ; i < rowSort.size() ; i++){
          res[i][map.get(rowSort.get(i))] = rowSort.get(i);
        }

        return res;
    }

    private List<Integer> topo(List<List<Integer>> adj , int[] indegree , int k){
      Queue<Integer> q = new LinkedList<>();
      List<Integer> res = new ArrayList<>();

      for(int i = 1 ; i <= k ; i++){
        if(indegree[i] == 0){
          q.offer(i);
        }
      }

      while(!q.isEmpty()){
        int node = q.poll();
        res.add(node);

        for(int child : adj.get(node)){
          indegree[child]--;
          if(indegree[child] == 0){
            q.offer(child);
          }
        }
      }

      return res;
    }
}