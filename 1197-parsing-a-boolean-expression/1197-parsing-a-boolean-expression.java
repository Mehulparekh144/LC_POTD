class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();
        char[] arr = expression.toCharArray();

        for (char ch : arr) {
            if (ch == ',')
                continue;
            else if (ch != ')') {
                st.push(ch);
            } else {
                boolean hasTrue = false;
                boolean hasFalse = false;

                while (!st.isEmpty() && st.peek() != '(') {
                    char temp = st.pop();
                    if (temp == 't')
                        hasTrue = true;
                    else if (temp == 'f')
                        hasFalse = true;
                }

                st.pop(); // Removing '(';

                char operand = st.pop();
                st.push(evaluate(hasTrue, hasFalse, operand));
            }
        }

        return st.peek() == 't';
    }

    public char evaluate(boolean hasTrue, boolean hasFalse, char operand) {
        if (operand == '!') {
            if (hasTrue) {
                return 'f';
            } else {
                return 't';
            }
        }

        else if (operand == '|') {
            if (hasTrue) {
                return 't';
            } else {
                return 'f';
            }
        }

        else if (operand == '&') {
            if (hasFalse) {
                return 'f';
            } else {
                return 't';
            }
        }

        else {
            return 'a';
        }
    }
}