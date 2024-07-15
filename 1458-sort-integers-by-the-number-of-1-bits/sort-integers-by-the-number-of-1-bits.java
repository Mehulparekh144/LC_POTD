class Solution {
    public int[] sortByBits(int[] arr) {
        List<Integer>[] count = new List[32];
        for(int i = 0; i < 32; i++){
            count[i] = new ArrayList<>();
        }

        for(int a : arr){
            int setBits = countSetBits(a);
            count[setBits].add(a);
        }

        int[] res = new int[arr.length];
        int i = 0;
        for(List<Integer> c : count){
            Collections.sort(c);
            for(int ele : c){
                res[i++] = ele;
            }
        }

        return res;

    }

    private int countSetBits(int n){
        int count = 0;

        while(n > 1){
            count += n & 1;
            n >>= 1;
        }

        if(n == 1) count++;
        return count;
    }
}