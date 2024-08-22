class Solution {
    public boolean isAlienSorted(String[] words, String order) {
       Map<Character,Integer> map = new HashMap<>();

      int i = 0;
       for(char c : order.toCharArray()){
        map.put(c , i++);
       } 

       for(int j = 0 ; j < words.length - 1 ; j++){
        if(!check(words[j] , words[j+1] , map)) return false;
       }
       
       return true;
    }

    private boolean check(String s , String t , Map<Character,Integer> map){
      int s1 = s.length();
      int s2 = t.length();

      for(int i = 0 ; i < Math.min(s1 , s2)  ; i++){
        if(map.get(s.charAt(i)) > map.get(t.charAt(i))){
          return false;
        } else if(map.get(s.charAt(i)) < map.get(t.charAt(i))){
          return true;
        }
      }

      if(s2 >= s1) return true;
      return false;
    }

}