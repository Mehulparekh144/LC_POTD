class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                open++;
            } else{
                if(open > 0){
                    open--; // closing paranthesis
                } else{
                    close++; // extra closing paranthesis
                }
            }
        }

        return open + close;
    }
}