class Solution {
    public int minimumPushes(String word) {
        int[] map = new int[26];
        for(char c : word.toCharArray()){
          map[c - 'a']++;
        }

        Arrays.sort(map);
        int ans = 0;
        int count = 0;
        for(int i = 25 ; i >= 0 ; i--){
          if(map[i] > 0){
            ans += map[i] * (count++/8 + 1);          
          }
        }

        return ans;
    }
}