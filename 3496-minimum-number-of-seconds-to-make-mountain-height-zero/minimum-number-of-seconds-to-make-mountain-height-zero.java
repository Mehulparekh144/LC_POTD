class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low = 0;
        long high = (long) mountainHeight * (mountainHeight + 1) / 2 * 1_000_000;

        while(low < high){
          long mid = (low) + (high - low)/2;
          if(can(mid , mountainHeight , workerTimes)){
            high = mid;
          } else{
            low = mid + 1;
          }
        }

        return low;
    }

    private boolean can(long mid , int height , int[] workerTimes){
      long currHeight = 0;

      for(int wt : workerTimes){
        long x = 0;
        long currentTime = 0;

        while(true){
          long nextTime = currentTime + wt * (x + 1);
          if(nextTime > mid) break;
          currentTime = nextTime;
          currHeight++;
          x++;
        }

        if(currHeight >= height) return true;
      }

      return false;
    }
}