class Solution {
    public int maxTurbulenceSize(int[] arr) {
      int l = 0;
      int r = 1;
      int n = arr.length;
      char prev = '#';
      int res = 1;

      while(r < n){
          if(arr[r-1] > arr[r] && prev != '>'){
            res = Math.max(res , r - l + 1);
            r++;
            prev = '>';
          } else if(arr[r-1] < arr[r] && prev != '<'){
            res = Math.max(res , r - l + 1);
            r++;
            prev = '<';
          } else{
            if(arr[r] == arr[r-1]){
              r++;
            }
            l = r - 1;
            prev = '#';
          }

      }

      return res;
    }
}