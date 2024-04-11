public class MinimumLength {

  // https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/

  public int minimumLength(String s) {
    char[] chars = s.toCharArray();
    int prefix = 0;
    int suffix = s.length() - 1;
    while (prefix < suffix && chars[prefix] == chars[suffix]) {
        char c = chars[prefix];
        while (prefix < suffix && chars[prefix] == c) {
          prefix += 1;
        }
        while (prefix <= suffix && chars[suffix] == c) {
          suffix -= 1;
        }
      }
    

    return suffix - prefix + 1;
  }

  public static void main(String[] args) {
    MinimumLength obj = new MinimumLength();
    System.out.println(obj.minimumLength("aabccabba"));
  }
}
