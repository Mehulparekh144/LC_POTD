class Pair{
  int idx;
  char ch;

  public Pair(int idx , char ch){
    this.idx = idx;
    this.ch = ch;
  }
}
class Solution {
    public String pushDominoes(String dominoes) {
      char[] dom = dominoes.toCharArray();
      Deque<Pair> dq = new LinkedList<>();

      for(int i = 0 ; i < dom.length ; i++){
        if(dom[i] == '.') continue;
        dq.offerLast(new Pair(i , dom[i]));
      }

      while(!dq.isEmpty()){
        Pair p = dq.pollFirst();
        int i = p.idx;
        char ch = p.ch;

        if(ch == 'L'){
          if(i > 0 && dom[i-1] == '.'){
            dq.offerLast(new Pair(i-1 , 'L'));
            dom[i-1] = 'L';
          }
        } else if(ch == 'R'){
          if(i + 1 < dom.length && dom[i+1] == '.' ){
            if(i+2 < dom.length && dom[i+2] == 'L'){
              dq.pollFirst();
            } else{
              dq.offerLast(new Pair(i+1 , 'R'));
              dom[i+1] = 'R';
            }
          }
        }
      }

      return new String(dom);
    }
}