class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] histogram = new int[n];
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    histogram[j]++;
                } else {
                    histogram[j] = 0;
                }
            }

            max = Math.max(max, maximumAreaOfHistogram(histogram));
        }

        return max;
    }

    private int maximumAreaOfHistogram(int[] histogram) {
        int n = histogram.length;
        int[] nsr = new int[n];
        int[] nsl = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && histogram[st.peek()] >= histogram[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = st.peek();
            }

            st.push(i);
        }

        st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && histogram[st.peek()] >= histogram[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = st.peek();
            }

            st.push(i);
        }

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int area = (nsr[i] - nsl[i] - 1) * histogram[i];
            if (area > maxArea)
                maxArea = area;
        }

        return maxArea;
    }
}