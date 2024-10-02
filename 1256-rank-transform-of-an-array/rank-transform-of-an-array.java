class Solution {
    public int[] arrayRankTransform(int[] arr) {      
      Set<Integer> s = new TreeSet<>();
      for(int a : arr) s.add(a);
      Map<Integer,Integer> map = new HashMap<>();

      int idx = 0;
      for(int a : s){
        map.put(a , idx+1);
        idx++;
      }

      int[] ans = new int[arr.length];
      for(int i = 0 ; i < arr.length ; i++){
        ans[i] = map.get(arr[i]);
      }

      return ans;
    }
}