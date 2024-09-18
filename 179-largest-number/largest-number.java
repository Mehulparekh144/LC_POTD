class Solution {
  public String largestNumber(int[] nums) {
    List<String> list = new ArrayList<>();
    for (int n : nums) {
      list.add(String.valueOf(n));
    }

    list.sort((a,b) -> (b + a).compareTo(a+b) );

    StringBuilder ans = new StringBuilder();
    for (String a : list)
      ans.append(a);
    
    if(ans.charAt(0) == '0') return "0";
    return ans.toString();
  }
}