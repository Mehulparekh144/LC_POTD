class Solution {
  public int[] topKFrequent(int[] nums, int k) {
  
      Map<Integer, Integer> map = new HashMap<>();
      for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }
  
      List<Integer>[] freq = new List[nums.length + 1];
  
      for (int i = 0; i < freq.length; i++) {
        freq[i] = new ArrayList<>();
      }
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        freq[entry.getValue()].add(entry.getKey());
      }
    
      List<Integer> ans = new ArrayList<>();
      for (int i = freq.length - 1; i >= 0; i--) {
        for (int j = 0; j < freq[i].size(); j++) {
          ans.add(freq[i].get(j));
          if (ans.size() == k) {
            break;
          }
        }
        if (ans.size() == k) {
          break;
        }
      }
  
      int idx = 0;
      int[] res = new int[ans.size()];
      for (int num : ans) {
        res[idx++] = num;
      }
  
      return res;
  
    }
}