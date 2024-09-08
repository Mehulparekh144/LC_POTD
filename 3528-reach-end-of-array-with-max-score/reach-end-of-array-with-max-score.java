class Solution {
    public long findMaximumScore(List<Integer> nums) {
        long ans = 0;
        int curr = nums.getFirst();

        for(int i = 1 ; i < nums.size() ; i++){
          ans += curr;
          curr = Math.max(curr , nums.get(i));
        }

        return ans;
    }
}