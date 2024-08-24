class Solution {
  public String nearestPalindromic(String s) {
    int n = s.length();

    if (n == 1) {
      return String.valueOf(Integer.parseInt(s) - 1);
    }

    long num = Long.parseLong(s);
    List<Long> candidates = new ArrayList<>();

    // Lower and upper bounds
    // Lower 10^6 -> 10^5 - 1 = 9999
    // Upper 10^6 -> 10^6 + 1 
    candidates.add((long) Math.pow(10, n - 1) - 1);
    candidates.add((long) Math.pow(10, n) + 1);

    long firstHalf = Long.parseLong(s.substring(0, (n + 1) / 2));

    for (int i = -1; i <= 1; i++) {
      String newHalf = String.valueOf(firstHalf + i);
      String candidate = getPalindrome(newHalf, n % 2 == 0);
      candidates.add(Long.parseLong(candidate));
    }

    // Find palindrome with closest diff
    long closest = -1;

    for(long candidate : candidates){
      if(candidate != num){
        if(closest == -1 || 
        Math.abs(candidate - num) < Math.abs(closest - num ) ||
        (Math.abs(candidate - num) == Math.abs(closest - num) && closest > candidate) ){
          closest = candidate;
        }
      }
    }

    return String.valueOf(closest);

  }

  private String getPalindrome(String s, boolean isEven) {
    StringBuilder sb = new StringBuilder(s);
    if (isEven) {
      sb.append(new StringBuilder(s).reverse().toString());
    } else {
      sb.append(new StringBuilder(s.substring(0, s.length() - 1)).reverse().toString());
    }

    return sb.toString();
  }
}