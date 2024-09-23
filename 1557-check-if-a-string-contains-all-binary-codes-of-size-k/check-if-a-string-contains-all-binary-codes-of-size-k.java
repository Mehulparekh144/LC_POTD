class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        int combinations = 1 << k;

        int i = 0;
        int j = i + k;

        while(j <= s.length()){
          set.add(s.substring(i , j));
          i++;
          j++;
        }

        return set.size() == combinations;
    }
}