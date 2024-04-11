public class MaximumOnes {

  public String maximumOddBinaryNumber(String s) {
    int n = s.length();
    char[] result = new char[n];
    for (int i = 0; i < n; i++) {
      result[i] = '0';
    }
    int ones = 0;
    for (char c : s.toCharArray()) {
      if (c == '1') {
        ones += 1;
      }
    }
    result[n - 1] = '1';
    ones -= 1;
    int i = 0;
    while (ones != 0 && i < n) {
      ones -= 1;
      result[i] = '1';
      i++;
    }
    return new String(result);
  }

  public static void main(String[] args) {
    MaximumOnes solver = new MaximumOnes();
    System.out.println(solver.maximumOddBinaryNumber("101"));
  }
}