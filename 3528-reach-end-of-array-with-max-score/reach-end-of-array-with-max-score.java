class Solution {
    public long findMaximumScore(List<Integer> nums) {
        long ans = 0;
        int curr = nums.getFirst();
        // You will always jump to the number which is greater than the curr 
        for(int i = 1 ; i < nums.size() ; i++){
          ans += curr;
          curr = Math.max(curr , nums.get(i));
        }

        return ans;
    }
}