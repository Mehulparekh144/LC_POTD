class Solution {
    public int numTrees(int n) {
      int[] nodes = new int[n+1];
      Arrays.fill(nodes , 1);

      for(int i = 2 ; i <= n ; i++){

        int total = 0;
        for(int root = 1 ; root <= i ; root++){
          int left = root - 1;
          int right = i - root;
          total += nodes[left]*nodes[right];
        }

        nodes[i] = total;
      }

      return nodes[n];
    }
}