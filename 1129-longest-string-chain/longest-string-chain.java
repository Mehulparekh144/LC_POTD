class Solution {
    public int longestStrChain(String[] words) {
                Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int[] dp = new int[n];

        Arrays.fill(dp , 1);

        for(int i = 0 ; i < n ; i++){
            for(int prev = 0 ; prev < i ; prev++){
                if(isPossible(words[prev] , words[i]) && 1 + dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev];
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }


    private boolean isPossible(String prev , String curr){
        if(curr.length() != prev.length() + 1){
            return false;
        }

        int i = 0;
        int j = 0;

        while(i < curr.length()){
            if(j < prev.length() && curr.charAt(i) == prev.charAt(j)){
                i++;
                j++;
            } else{
                i++;
            }
        }

        return i == curr.length() && j == prev.length();


    }

}