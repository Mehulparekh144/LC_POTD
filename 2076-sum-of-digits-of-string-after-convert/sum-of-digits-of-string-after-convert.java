class Solution {
    public int getLucky(String s, int k) {
        String num = "";
        for(char c : s.toCharArray()){
          num += String.valueOf(c - 'a' + 1);
        }

        while(k > 0){
          int sum = 0;

          for(char c : num.toCharArray()){
            sum += c - '0';
          }

          num = String.valueOf(sum);
          k--;
        }

        return Integer.parseInt(num) ;
    }
}