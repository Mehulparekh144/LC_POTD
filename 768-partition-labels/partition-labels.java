class Solution {
    public List<Integer> partitionLabels(String s) {
      int n = s.length();
      Map<Character,Integer> map = new HashMap<>();

      for(int i = 0 ; i < n ; i++){
        map.put(s.charAt(i) , i);
      }

      int maxOccurence = 0;
      List<Integer> res = new ArrayList<>();
      int start = 0;

      for(int i = 0 ; i < n ; i++){
        maxOccurence = Math.max(maxOccurence , map.get(s.charAt(i)));

        if(i == maxOccurence){
          res.add(i + 1 - start);
          start = i + 1;
        }
      }

      return res;


    }
}