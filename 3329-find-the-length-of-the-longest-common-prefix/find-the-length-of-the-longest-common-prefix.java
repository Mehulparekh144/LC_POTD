class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Map<String,Integer> map = new HashMap<>();

        for(int n : arr1){
          String num = String.valueOf(n);
          String pfx = "";

          for(char ch : num.toCharArray()){
            pfx += ch;
            map.put(pfx , map.getOrDefault(pfx , 0) + 1);
          }
        }

        int ans = 0;

        for(int n : arr2){
          String num = String.valueOf(n);
          String pfx = "";

          for(char ch : num.toCharArray()){
            pfx += ch;

            if(map.containsKey(pfx)){
              ans = Math.max(ans , pfx.length());
            }
          }
        }

        return ans;
    }
}