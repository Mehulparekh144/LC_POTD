class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> collected = new HashMap<>();
        int l = 0;

        int len = 0;
        for(int r = 0 ; r < fruits.length ; r++){
          collected.put(fruits[r] , collected.getOrDefault(fruits[r] , 0) + 1);

          if(collected.size() > 2){
            collected.put(fruits[l] , collected.get(fruits[l]) - 1);
            if(collected.get(fruits[l]) == 0) collected.remove(fruits[l]);
            l++;
          }

          len = Math.max(len , r - l + 1);
        }

        return len;
    }
}