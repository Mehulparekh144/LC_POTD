class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;

        List<Integer> list = new ArrayList<>();

        for(int r = 0 ; r < arr.length ; r++){
          list.add(arr[r]);

          if(list.size() > k){
            int a = arr[l];
            int b = list.getLast();

            if(Math.abs(a - x) < Math.abs(b-x) || (Math.abs(a - x) == Math.abs(b-x) && a < b)){
              list.removeLast();
              break;
            } else{
              list.removeFirst();
              l++;
            }
          }
        }

        return list;
    }
}