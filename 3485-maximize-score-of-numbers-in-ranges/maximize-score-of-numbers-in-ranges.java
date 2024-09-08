class Solution {
 public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        int l = 0;
        int r = Integer.MAX_VALUE;
        int res = 0;
        
        while (l <= r) {
            int mid = l + (r-l)/ 2;
            
            if (isPossible(mid, start, d)) {
                res = mid; 
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return res;
    }
    
    private boolean isPossible(int v, int[] start, int d) {
        int prev = start[0];

        for (int i = 1; i < start.length; i++) {
            int next = prev + v;
            
            if (next > start[i] + d) {
                return false;
            }
            
            
            prev = Math.max(start[i], next);
        }

        return true;
    }
    
}