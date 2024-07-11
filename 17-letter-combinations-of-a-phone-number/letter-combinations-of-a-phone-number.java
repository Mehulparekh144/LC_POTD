class Solution {
  public List<String> letterCombinations(String digits) {
    if(digits.isEmpty()){
      return new ArrayList<>();
    }
    Map<Character, String> map = new HashMap<>();
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");

    List<String> res = new ArrayList<>();
    solve(0, digits, "", res, map);
    return res;
  }

  private void solve(int i, String digits, String path, List<String> res, Map<Character, String> map) {
    if (path.length() == digits.length()) {
      res.add(path.toString());
      return;
    }

    for (char c : map.get(digits.charAt(i)).toCharArray()) {
      solve(i + 1, digits, path + c, res, map);
    }
  }
}