class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < numCourses ; i++){
          adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] edge : prerequisites){
          adj.get(edge[1]).add(edge[0]);
          indegree[edge[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < numCourses ; i++){
          if(indegree[i] == 0) q.offer(i);
        }        

        int i = 0;
        int[] res = new int[numCourses];
        int count = 0;
        while(!q.isEmpty()){
          int node = q.poll();
          count++;
          res[i++] = node;

          for(int child : adj.get(node)){
            indegree[child]--;
            if(indegree[child] == 0){
              q.offer(child);
            }
          }
        }

        if(count != numCourses){
          return new int[]{};
        }

        return res;
    }
}