class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long res = 0;
        int c = 0;

        for(int i = happiness.length - 1 ; i >= 0 ; i--){
            if(k == 0){
                return res;
            }
            if(happiness[i] - c < 0){
                res += 0;
            } else{
                res += happiness[i] - c;
            }
            k--;
            c += 1;
        }

        if(k == 0){
            return res;
        }


        return 0;

    }
}