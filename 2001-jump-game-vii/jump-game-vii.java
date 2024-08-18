class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
      int n = s.length();
      Queue<Integer> q = new LinkedList<>();
      int farthest = 0;

      q.offer(0);

      while(!q.isEmpty()){
        int i = q.poll();
        int start = Math.max(
          farthest + 1,
          i + minJump
        );

        for(int j = start ; j <= Math.min(i + maxJump , n-1) ; j++){
          if(s.charAt(j) == '0'){
            q.offer(j);
            if(j == n-1) return true;
          }
        }

        farthest = Math.max(farthest, i + maxJump);
      }

      return false;

  }
}