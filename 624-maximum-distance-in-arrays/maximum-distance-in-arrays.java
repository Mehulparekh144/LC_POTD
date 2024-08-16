class Solution {
    public int maxDistance(List<List<Integer>> arrays) {

        int minVal = arrays.get(0).getFirst();
        int maxVal = arrays.get(0).getLast();
        int maxDistance = 0;


        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);
            int currentMin = currentArray.getFirst();
            int currentMax = currentArray.getLast();


            maxDistance = Math.max(maxDistance, Math.abs(currentMax - minVal));
            maxDistance = Math.max(maxDistance, Math.abs(maxVal - currentMin));

            minVal = Math.min(minVal, currentMin);
            maxVal = Math.max(maxVal, currentMax);
        }

        return maxDistance;
    }
  }