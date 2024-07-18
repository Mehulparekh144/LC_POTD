class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); 

        String word = "";
        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < searchWord.length(); i++) {
            word += searchWord.charAt(i);

            int l = 0;
            int r = products.length - 1;
            List<String> temp = new ArrayList<>();

        
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (products[m].startsWith(word)) {
                    r = m - 1;
                } else if (products[m].compareTo(word) < 0) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }

            for (int j = l; j < Math.min(l + 3, products.length) && products[j].startsWith(word); j++) {
                temp.add(products[j]);
            }

            res.add(temp);
        }

        return res;
    }

}