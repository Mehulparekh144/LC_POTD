class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i <= word.length() ; i+=k){
            String subString = word.substring(i , Math.min(i+k , word.length()));
            map.put(subString , map.getOrDefault(subString , 0) + 1);
        }

        int maxValue = 0;
        for(int value : map.values()){
            maxValue = Math.max(maxValue , value);
        }

        return word.length()/k - maxValue;
        
    }
}