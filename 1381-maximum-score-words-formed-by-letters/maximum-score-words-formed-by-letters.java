class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];
        for(char l : letters){
          freq[l - 'a']++;
        }

        return solve(0 , words , letters , score , freq);
    }

    private int solve(int i ,String[] words, char[] letters, int[] score , int[] freq ){
      if(i == words.length) return 0;

      int notTake = solve(i+1 , words, letters , score , freq);
      int take = 0;
      boolean canTake = true;

      int[] freq2 = freq.clone();

      for(char ch : words[i].toCharArray()){
        if(freq2[ch - 'a'] > 0){
          take += score[ch - 'a'];
          freq2[ch - 'a']--;
        } else{
          canTake = false;
          break;
        }
      }

      if(canTake){
        take += solve(i+1 , words , letters , score , freq2);
      } else{
        take = 0;
      }

      return Math.max(take , notTake);
    }
}