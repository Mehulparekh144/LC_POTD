class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer,Integer> count = new HashMap<>();

        for(int[] edge : edges){
            count.put(edge[0] , count.getOrDefault(edge[0] , 0) + 1);
            count.put(edge[1] , count.getOrDefault(edge[1] , 0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry : count.entrySet()){
            if(entry.getValue() == count.size() - 1){
                return entry.getKey();
            }
        }

        return 1;
    }
}