class Solution {
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }

        System.out.println(map.toString());

        String[] res = new String[score.length];

        Arrays.sort(score);
        int position = 1;
        for (int j = score.length - 1; j >= 0; j--) {
            if (position == 1) {
                res[map.get(score[j])] = "Gold Medal";
            } else if (position == 2) {
                res[map.get(score[j])] = "Silver Medal";
            } else if (position == 3) {
                res[map.get(score[j])] = "Bronze Medal";
            } else {
                res[map.get(score[j])] = String.valueOf(position);
            }

            position += 1;
        }

        return res;
    }
}