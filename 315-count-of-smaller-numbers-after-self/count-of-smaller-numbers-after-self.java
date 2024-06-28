class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> sorted = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            insert(sorted , nums[i] , res);
        }

        Collections.reverse(res);
        return res;
    }

    private void insert(List<Integer> sorted , int target , List<Integer> res){
        if(sorted.isEmpty()){
            sorted.add(target);
            res.addLast(0);
            return;
        }

        int l = 0;
        int r = sorted.size() - 1;

        while(l <= r){
            int m = l + (r-l)/2;

            if(sorted.get(m) < target){
                l = m + 1;
            } else{
                r = m - 1;
            }
        }

        sorted.add(l , target);
        res.add(l);

    }
}