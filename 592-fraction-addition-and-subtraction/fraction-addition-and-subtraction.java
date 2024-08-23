class Solution {
  public String fractionAddition(String expression) {
    int num = 0;
    int den = 1;
    int n = expression.length();

    int i = 0;
    while (i < n) {
      
      int currNum = 0;
      int currDen = 0;

      boolean isNeg = expression.charAt(i) == '-';

      if(expression.charAt(i) == '+' || expression.charAt(i) == '-'){
        i++;
      }

      while(i < n && Character.isDigit(expression.charAt(i))){
        int val = expression.charAt(i) - '0';
        currNum = currNum*10 + val;
        i++;
      }

      if(isNeg){
        currNum *= -1;
      }

      i++; // Skipping divide symbol

      while(i < n && Character.isDigit(expression.charAt(i))){
        int val = expression.charAt(i) - '0';
        currDen = currDen*10 + val;
        i++;
      }

      num = num*currDen + den*currNum;
      den = currDen * den;

    }

    int gcd = Math.abs(gcd(num , den));

    num /= gcd;
    den /= gcd;

    return num + "/" + den;
  }

  private int gcd(int a , int b){
    if(b == 0) return a;
    return gcd(b , a%b);
  }
}