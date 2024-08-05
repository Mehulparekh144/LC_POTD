class Solution {
    public String kthDistinct(String[] arr, int k) {
       Map<String,Integer> map = new LinkedHashMap<>();

       for(String s : arr){
        map.put(s , map.getOrDefault(s , 0 ) + 1);
       } 

       for(Map.Entry<String,Integer> entry : map.entrySet()){
        String key = entry.getKey();
        int val = entry.getValue();

        if(val != 1) continue;

        if(val == 1 && k == 1){
          return key;
        } else{
          k--;
        }
       }

       return "";
    }
}