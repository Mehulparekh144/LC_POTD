class Solution {
    public int findMinDifference(List<String> timePoints) {
      List<Integer> lis = new ArrayList<>();

      for(String t : timePoints){
        String[] arr = t.split(":");
        int hours = Integer.parseInt(arr[0]);
        int mins = Integer.parseInt(arr[1]);
        lis.add(hours*60 + mins);
      }

      int n = lis.size();

      Collections.sort(lis);

      int min = Integer.MAX_VALUE;

      for(int i = 1 ; i < n ; i++){
        min = Math.min(
          min , 
          lis.get(i) - lis.get(i-1)
        );
      }


      int diff = 1440 + lis.getFirst() - lis.getLast();
      return Math.min(min , diff);
      
    }
}