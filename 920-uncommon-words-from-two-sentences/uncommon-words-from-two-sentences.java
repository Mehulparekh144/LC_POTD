class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        
        String[] sa1 = s1.split(" ");
        String[] sa2 = s2.split(" ");

        for(String s : sa1){
          map.put(s , map.getOrDefault(s , 0) + 1);
        }

        for(String s : sa2){
          map.put(s , map.getOrDefault(s , 0) + 1);
        }

        map.forEach((k,v) -> {
          if(v == 1) list.add(k);
        });


        int idx = 0;
        String[] res = new String[list.size()];
        for(String s : list){
          res[idx++] = s;
        } 

        return res;
    }
}