class Solution {
  public int largestPathValue(String colors, int[][] edges) {
    // 1. TopoSort
    // 2. Check if there's a cycle or not
    int n = colors.length();
    List<List<Integer>> adj = new ArrayList<>();
    char[] s = colors.toCharArray();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    int[] indegree = new int[n];

    for (int[] e : edges) {
      adj.get(e[0]).add(e[1]);
      indegree[e[1]]++;
    }
    Queue<Integer> q = new LinkedList<>();
    int[][] mat = new int[n][26];

    for (int i = 0; i < n; i++) {
      if (indegree[i] == 0) {
        q.offer(i);
        mat[i][s[i] - 'a'] = 1;
      }
    }

    int nodes = 0 , ans = 0;
    while(!q.isEmpty()){
      int node = q.poll();
      nodes++;

      // Keep the max 
      ans = Math.max(ans , mat[node][s[node] - 'a']);

      for(int child : adj.get(node)){
        
        // Check for all the alphabets and see if from parent -> child there is an increment or not
        // eg. node is a and child is also a then mat[child][i] = mat[node][i] + 1, so if it was 1 it increases to 2
        for(int i = 0 ; i < 26 ; i++){
          mat[child][i] = Math.max(
            mat[child][i],
            mat[node][i] + (i == s[child] - 'a' ? 1 : 0)
          );
        }

        indegree[child]--;
        if(indegree[child] == 0){
          q.offer(child);
        }
      }
    }

    if(nodes != n) return -1; // Cycle

    return ans;

  }
}