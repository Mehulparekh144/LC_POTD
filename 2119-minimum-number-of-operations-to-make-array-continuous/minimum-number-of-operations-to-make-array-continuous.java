class Solution {
  public int minOperations(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums)
      set.add(num);
    List<Integer> list = new ArrayList<>(set);
    Collections.sort(list);
    int n = list.size();

    int r = 0;
    int res = nums.length;

    for (int l = 0; l < n; l++) {
      while (r < n && list.get(r) < list.get(l) + nums.length) {
        r++;
      }

      int window = r - l;
      res = Math.min(res, nums.length - window);
    }

    return res;
  }
}