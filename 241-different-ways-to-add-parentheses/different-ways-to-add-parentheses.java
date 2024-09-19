class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
      return solve(expression);
    }

    private List<Integer> solve(String s){
      List<Integer> res = new ArrayList<>();

      int n = s.length();

      for(int i = 0 ; i < n ; i++){
        if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' ){
          List<Integer> left = solve(s.substring(0 , i));
          List<Integer> right = solve(s.substring(i+1 , n));

          for(int l : left){
            for(int r : right){
              if(s.charAt(i) == '+'){
                res.add(l+r);
              } else if(s.charAt(i) == '-'){
                res.add(l-r);
              } else{
                res.add(l*r);
              }
            }
          }
        }
      }

      if(res.isEmpty()){
        res.add(Integer.parseInt(s));
      }

      return res;
    }
}