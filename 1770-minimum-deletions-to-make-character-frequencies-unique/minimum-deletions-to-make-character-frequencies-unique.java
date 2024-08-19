class Solution {
    public int minDeletions(String s) {
      Map<Character,Integer> map = new TreeMap<>();

      for(char c : s.toCharArray()){
        map.put(c , map.getOrDefault(c , 0 ) + 1);
      }  

      int n = map.size();

      Set<Integer> set = new HashSet<>();
      int dele = 0;

      for(int freq : map.values()){

        while(freq > 0 && !set.add(freq)){
          freq--;
          dele++;
        }
      }

      return dele;


    }
}