class Pair{
  char ch;
  int count;

  public Pair(char ch , int count){
    this.ch = ch;
    this.count = count;
  }
}
class Solution {
    public String removeDuplicates(String s, int k) {
      Stack<Pair> st = new Stack<>();

      for(char c : s.toCharArray()){
        if(!st.isEmpty() && st.peek().ch == c){
          st.peek().count++;
        } else{
          st.push(new Pair(c , 1));
        }

        if(st.peek().count == k){
          st.pop();
        }
      }

      StringBuilder sb = new StringBuilder();
      while(!st.isEmpty()){
        for(int i = 0 ; i < st.peek().count ; i++){
          sb.insert(0 , st.peek().ch);
        }

        st.pop();
      }

      return sb.toString();
    }
}