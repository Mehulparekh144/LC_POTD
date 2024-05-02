class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colored = new int[graph.length];
        Arrays.fill(colored, -1);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (colored[i] == -1) {
                q.offer(i);
                colored[i] = 0;

                while (!q.isEmpty()) {
                    int node = q.poll();

                    for (int child : graph[node]) {
                        if (colored[child] == -1) {
                            q.offer(child);
                            colored[child] = colored[node] == 0 ? 1 : 0;
                        } else if (colored[child] == colored[node]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

}