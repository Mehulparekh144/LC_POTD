class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int l = 0;
        int r = 0;
        List<Integer> res = new ArrayList<>();

        while(l < nums1.length && r < nums2.length){
          if(nums1[l] == nums2[r]){
            res.add(nums1[l]);
            l++;
            r++;
          }
          else if(nums1[l] < nums2[r]){
            l++;
          } else{
            r++;
          }
        }

        int[] ans = new int[res.size()];
        int idx = 0;
        for(int a : res){
          ans[idx++] = a;
        }

        return ans;
    }
}