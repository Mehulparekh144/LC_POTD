class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int i = 0;
        int j = i+1;
        int k = j+1;

        while(k < arr.length){
            if(arr[i]%2 != 0 && arr[j]%2 != 0 && arr[k]%2 != 0 ){
                return true;
            }

            i++;
            j++;
            k++;
        }

        return false;
        
    }
}