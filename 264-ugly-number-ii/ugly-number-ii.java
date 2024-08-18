class Solution {
  public int nthUglyNumber(int n) {
    List<Long> arr = new ArrayList<>(List.of(1L));
    int i2 = 0 , i3 = 0 , i5 = 0;

    for(int i = 1 ; i <= n ; i++){
      long next = Math.min(
        Math.min(arr.get(i2) * 2 , arr.get(i3)*3 ),
        arr.get(i5)*5
      );

      arr.add(next);
      if(next == arr.get(i2)*2){
       i2++;
      }

      if(next == arr.get(i3)*3){
       i3++;
      }

      if(next == arr.get(i5)*5){
       i5++;
      }

    }

    return (int)(long) arr.get(n-1);
  }
}