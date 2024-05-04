class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < graph.length ; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[graph.length];

        for(int i = 0 ; i < graph.length ; i++){
            for(int child : graph[i]){
                adj.get(child).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < graph.length ; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);

            for(int child : adj.get(node)){
                if(--indegree[child] == 0){
                    q.offer(child);
                } 
            }
        }

        Collections.sort(res);
        return res;
        
    }
}