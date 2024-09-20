class Solution {
    public int countPalindromicSubsequence(String s) {
        
        int[][] indices = new int[26][2];
        for(int[] row : indices) Arrays.fill(row , -1);

        for(int i = 0 ; i < s.length() ; i++){
          char ch = s.charAt(i);
          int idx = ch - 'a';

          if(indices[idx][0] == -1){
            indices[idx][0] = i;
          }

          indices[idx][1] = i;
        }

        int count = 0;
        // System.out.println(Arrays.deepToString(indices));

        for(int i = 0 ; i < 26 ; i++){
          int left = indices[i][0];
          int right = indices[i][1];

          if(left == -1) continue;

          Set<Character> set2 = new HashSet<>();
          for(int j = left + 1 ; j < right ; j++){
            set2.add(s.charAt(j));
          }

          count += set2.size();
        }

        return count;
    }
}