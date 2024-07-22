class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
      int max = Arrays.stream(heights).max().getAsInt();
      
      String[] count = new String[max + 1];

      for(int i = 0 ; i < names.length ; i++){
        count[heights[i]] = names[i];
      }

      int idx = 0;
      String[] res = new String[names.length];
      for(int i = count.length - 1 ; i >= 0 ; i--){
        if(count[i] != null){
          res[idx++] = count[i];
        }
      }

      return res;
    }
}