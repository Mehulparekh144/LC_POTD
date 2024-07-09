class Solution {
    public double averageWaitingTime(int[][] customers) {
      int last = customers[0][0] + customers[0][1];
      double sum = last - customers[0][0];

      for(int i = 1 ; i < customers.length ; i++){
        int start = customers[i][0];
        int end = customers[i][1];
        int total = start + end;
        if(start < last){
          total += (last - start);
        }

        sum += total - start;
        last = total;
      }  

      return (double)sum/customers.length;
    }
}