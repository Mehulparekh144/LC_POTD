class Solution {
    private boolean dfs(int course , List<List<Integer>> adj , boolean[] visited , Stack<Integer> st){
        visited[course] = true;
        st.push(course);

        for(int child : adj.get(course)){
            if(!visited[child]){
                if(!dfs(child , adj , visited , st)) return false; 
            } else if(st.contains(child)){
                return false;
            }
        }

        st.pop();
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Stack<Integer> st = new Stack<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] preq : prerequisites){
            adj.get(preq[1]).add(preq[0]);
        }

        boolean[] visited = new boolean[numCourses];

        for(int i = 0 ; i < numCourses ;i++){
            if(!visited[i]){
                if(!dfs(i , adj , visited , st)){
                    return false;
                }
            }
        }

        return true;
    }
}