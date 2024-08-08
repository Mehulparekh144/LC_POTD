class Solution {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<int[]> jobs = new ArrayList<>();
        for(int i = 0 ; i < startTime.length ; i++){
          jobs.add(new int[]{startTime[i] , endTime[i] , profit[i]});
        }

        int n = profit.length;
        Collections.sort(jobs , (a,b) -> a[0] - b[0]);

        int[] dp = new int[n];
        dp[n-1] = jobs.get(n-1)[2];

        for(int i = n-2 ; i >= 0 ; i--){
          int np = dp[i+1];

          int p = jobs.get(i)[2];
          int nextIdx = nextJob(jobs , i);

          if(nextIdx != -1){
            p += dp[nextIdx];
          }

          dp[i] = Math.max(p , np);
        }

        return dp[0];
        
    }

    private int nextJob(List<int[]> jobs , int curr){
      int l = curr + 1;
      int r = jobs.size() - 1;

      int end = jobs.get(curr)[1];
      while(l <= r){
        int m = l + (r-l)/2;

        if(jobs.get(m)[0] >= end){
          r = m - 1;
        } else{
          l = m + 1;
        }
      }

      return l < jobs.size() ? l : -1;
    }

   
}