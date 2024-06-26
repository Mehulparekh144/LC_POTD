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
        Stack<Integer> st = new Stack<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= n; i++) {

            while(!st.isEmpty() && (i == n || histogram[st.peek()] >= histogram[i])){
                
                int h = histogram[st.pop()];
                int w = 0;
                if(st.isEmpty()){
                    w = i; 
                } else{
                    w = i - st.peek() - 1;
                }

                int area = h*w;
                max = Math.max(area , max);
            }

            st.push(i);
        }

        return max;


    }
}