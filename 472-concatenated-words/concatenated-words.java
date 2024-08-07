class Solution {
  Map<String,Boolean> dp;
  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    List<String> res = new ArrayList<>();
    Set<String> w = new HashSet<>(List.of(words));
    dp = new HashMap<>();

    for (String word : words) {
      if (dfs(word, w)) {
        res.add(word);
      }
    }

    return res;
  }

  private boolean dfs(String word, Set<String> w) {

    if(dp.containsKey(word)) return dp.get(word);

    for (int i = 1; i < word.length(); i++) {
      String pfx = word.substring(0, i);
      String sfx = word.substring(i);

      System.out.println(pfx);
      System.out.println(sfx);


      if ((w.contains(pfx) && w.contains(sfx)) || (w.contains(pfx) && dfs(sfx, w))) {
        dp.put(word,true);
        return true;
      }

    }
    dp.put(word, false);
    return false;
  }

}