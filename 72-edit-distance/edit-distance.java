class Solution {
    public int minDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];

        for(int j = 0 ; j <= n ; j++){
            prev[j] = j;
        } 

        for(int i = 1 ; i <= m ; i++){
            curr[0] = i;
            for(int j = 1 ; j <= n ; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    curr[j] = prev[j-1];
                } else{
                    int insert = 1 + curr[j-1];
                    int delete = 1 + prev[j];
                    int replace = 1 + prev[j-1];
                    curr[j] = Math.min(insert , Math.min(replace , delete));
                }
            }
            prev = curr.clone();
        }

        return prev[n];

    }

}