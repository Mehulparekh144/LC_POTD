class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> s = new HashSet<>();
        List<Integer> r = new ArrayList<>();

        for(int n : nums){
          if(s.contains(n)){
            r.add(n);
            continue;
          }

          s.add(n);
        }

        int[] res = new int[r.size()];
        for(int i = 0 ; i < r.size() ; i++){
          res[i] = r.get(i);
        }

        return res;

    }
}