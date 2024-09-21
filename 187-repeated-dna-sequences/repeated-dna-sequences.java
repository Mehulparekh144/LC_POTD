class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int l = 0;
        int n = s.length();
        int r = l + 10;

        Map<String,Integer> map = new HashMap<>();

        while(r <= n){
          String sub = s.substring(l , r);
          map.put(sub , map.getOrDefault(sub , 0) + 1);
          l++;
          r++;
        }

        List<String> list = new ArrayList<>();
        for(Map.Entry<String,Integer> e : map.entrySet()){
          if(e.getValue() > 1){
            list.add(e.getKey());
          }
        }

        return list;

    }
}