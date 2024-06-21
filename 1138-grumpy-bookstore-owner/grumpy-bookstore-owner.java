class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int total = 0;
        int n = customers.length;
        for(int i = 0 ; i < n ; i++){
            if(grumpy[i] == 0){
                total += customers[i];
            }
        }

        int canBe = 0;
        for(int i = 0 ; i < minutes ; i++){
            if(grumpy[i] == 1){
                canBe += customers[i];
            }
        }

        int max = canBe;
        for(int i = minutes ; i < n ; i++){
            if(grumpy[i] == 1){
                canBe += customers[i];
            }

            if(grumpy[i - minutes] == 1){
                canBe -= customers[i - minutes];
            }

            max = Math.max(canBe , max);
        }

        return total + max;
    }
}