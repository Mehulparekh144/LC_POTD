class Solution {
    public int longestConsecutive(int[] nums) {
      Set<Integer> s = new HashSet<>();

      for(int n : nums){
        s.add(n);
      }   

      int longest = 0;
      for(int n : nums){
        if(s.contains(n-1)) continue;
        int j = 1;

        while(s.contains(n+j)) j++;
        longest = Math.max(longest , j);
      }

      return longest;
    }
}