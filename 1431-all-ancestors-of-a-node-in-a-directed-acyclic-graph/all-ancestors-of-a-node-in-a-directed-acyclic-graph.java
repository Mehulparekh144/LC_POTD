class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> indegree = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            indegree.add(new ArrayList<>());
            res.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];

            indegree.get(to).add(from);
        }

        for(int i = 0 ; i < n ; i++){
            boolean[] visited = new boolean[n];
            dfs(i , indegree , visited , res.get(i));
        }

        for(List<Integer> ancestors : res){
            Collections.sort(ancestors);
        }

        return res;       
    }

    private void dfs(int node , List<List<Integer>> indegree , boolean[] visited , List<Integer> ancestors){
        for(int ancestor : indegree.get(node)){
            if(!visited[ancestor]){
                visited[ancestor] = true;
                ancestors.add(ancestor);
                dfs(ancestor , indegree , visited , ancestors);
            }
        }
    }

}