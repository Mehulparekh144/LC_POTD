class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(possible(mid , bloomDay , m , k)){
                ans = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }

        return ans == 0 ? -1 : ans;
    }

    private boolean possible(int day , int[] bloomDay , int m , int k){
        int count = 0;
        int bouq = 0;

        for(int d : bloomDay){
            if(day >= d){
                count++;
            } else{
                bouq += count/k;
                count = 0;
            }
        }

        bouq += count/k;

        return bouq >= m;
    }
}