class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int bottles = 0;

        while(numBottles/numExchange > 0){
          int newBottles = numBottles/numExchange;
          int drank = numExchange * newBottles;
          bottles += drank;
          numBottles += newBottles;
          numBottles -= drank;

        }

        return bottles + numBottles;
    }
}