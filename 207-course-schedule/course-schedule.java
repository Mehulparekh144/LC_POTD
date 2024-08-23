class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      int[] indegree = new int[numCourses];

      List<List<Integer>> adj = new ArrayList<>();
      for(int i = 0 ; i < numCourses ; i++){
        adj.add(new ArrayList<>());
      }

      for(int[] edge : prerequisites){
        adj.get(edge[1]).add(edge[0]);
        indegree[edge[0]]++;
      }

      Queue<Integer> q = new LinkedList<>();
      for(int i = 0 ; i < numCourses ; i++){
        if(indegree[i] == 0){
          q.offer(i);
        }
      }

      int count = 0;

      while(!q.isEmpty()){
        int node = q.poll();
        count++;

        for(int child : adj.get(node)){
          indegree[child]--;
          if(indegree[child] == 0){
            q.offer(child);
          }
        }
      }

      return count == numCourses;



    }


}