class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int res = 0;
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < profit.length; i++) {
            list.add(new int[] { difficulty[i], profit[i] });
        }

        Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(worker);

        int maxProfit = 0;
        int idx = 0;

        for (int w : worker) {

            while (idx < difficulty.length && w >= list.get(idx)[0]) {
                maxProfit = Math.max(maxProfit, list.get(idx)[1]);
                idx++;
            }

            res += maxProfit;
        }
        return res;
    }
}