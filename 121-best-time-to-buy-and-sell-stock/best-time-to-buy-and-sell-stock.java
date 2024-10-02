class Solution {
    public int maxProfit(int[] prices) {
      int price = prices[0];
      int max = 0;

      for(int p : prices){
        if(p >= price){
          max = Math.max(max , p - price);
        } else{
          price = p;
        }
      }   

      return max;
    }
}