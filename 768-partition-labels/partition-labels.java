class Solution {
    public List<Integer> partitionLabels(String s) {
     Map<Character,Integer> map = new HashMap<>();
     List<Integer> res = new ArrayList<>();

     for(int i = 0 ; i < s.length() ; i++){
        map.put(s.charAt(i) , i);
     }   

     int size = 0;
     int end = 0;

     for(int i = 0 ; i < s.length() ; i++){
        char c = s.charAt(i);
        size += 1;
        end = Math.max(end , map.get(c));
        if(i == end){
            res.add(size);
            size = 0;
        }
     }

     return res;
    }
}