class Solution {
    public int numDecodings(String s) {
        int prev = 1;
        int prev2 = 0;
        int curr = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                curr = 0;

            } else {
                int step1 = prev;
                int step2 = 0;
                if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
                    step2 = prev2;
                }

                curr = step1 + step2;

            }
            prev2 = prev;
            prev = curr;

        }

        return curr;

    }
}
