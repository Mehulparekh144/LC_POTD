class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();

        for(char c : expression.toCharArray()){
            if(c == ',') continue;
            else if(c != ')'){
                st.push(c);
            } else{
                boolean hasTrue = false;
                boolean hasFalse = false;

                while(!st.isEmpty() && st.peek() != '('){
                    char ch = st.pop();
                    if(ch == 't'){
                        hasTrue = true;
                    } else if(ch == 'f'){
                        hasFalse = true;
                    }
                }

                st.pop(); // Remove (

                st.push(eval(hasTrue , hasFalse , st.pop()));
            }
        }

        return st.peek() == 't';
    }


    private char eval(boolean hasTrue , boolean hasFalse , char operator){
        if(operator == '|'){
            if(hasTrue){
                return 't';
            } else{
                return 'f';
            }
        }

        else if(operator == '&'){
            if(hasFalse){
                return 'f';
            } else{
                return 't';
            }
        }

        else if(operator == '!'){
            if(hasTrue){
                return 'f';
            } else{
                return 't';
            }
        } 

        else{
            return 'a';
        }


    }
}