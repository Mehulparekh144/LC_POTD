class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        int x = 1;
        
        for(int i = 0 ; i < n ; i++){
            list.add(x);
            
            if(x*10 > n){
                if(x == n) x/= 10;
                x++;
                while(x%10 == 0){
                    x/= 10;
                }
            } else{            
            x *= 10;
            }
        }
        
        return list;
    }
}