class Solution {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        String[] under19 =  "One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten,Eleven,Twelve,Thirteen,Fourteen,Fifteen,Sixteen,Seventeen,Eighteen,Nineteen".split(",");
        String[] tens =  "Twenty,Thirty,Forty,Fifty,Sixty,Seventy,Eighty,Ninety".split(",");
        String[] units = {"", "Thousand", "Million", "Billion"};

        String words = "";
        int i = 0;

        while (num > 0) {
            int segment = num % 1000;
            if (segment > 0) {
                words = words(segment, tens, under19) + (units[i].isEmpty() ? "" : " " + units[i]) + (words.isEmpty() ? "" : " " + words);
            }
            num /= 1000;
            i++;
        }

        return words.trim();
    }

    private String words(int n, String[] tens, String[] under19) {
        if (n < 20) {
            return under19[n - 1];
        }
        if (n < 100) {
            return tens[n / 10 - 2] + (n % 10 > 0 ? " " + words(n % 10, tens, under19) : "");
        }
        return under19[n / 100 - 1] + " Hundred" + (n % 100 > 0 ? " " + words(n % 100, tens, under19) : "");
    }
}
