class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer,Integer> amap = new HashMap<>();
        Map<Integer,Integer> tmap = new HashMap<>();
        
        for(int num : arr){
            amap.put(num , amap.getOrDefault(num , 0) + 1);
        }
        
        for(int num : target){
            tmap.put(num , tmap.getOrDefault(num , 0) + 1);
        }

        
        return amap.equals(tmap);
    }
}