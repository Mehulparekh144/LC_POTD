class Solution {
    public String simplifyPath(String path) {
        String[] words = path.split("/");

        Stack<String> st = new Stack<>();

        for(String w : words){
          if(w.equals(".") || w.isEmpty()){
            continue;
          } else if(w.equals("..")){
            if(st.isEmpty()) continue;
            st.pop();
          } else{
            st.push(w);
          }
        }

        List<String> l = new ArrayList<>();
        while(!st.isEmpty()){
          l.addFirst(st.pop());
          l.addFirst("/");
        }

        if(l.isEmpty()) return "/";

        String s = "";
        for(String w : l){
          s += w;
        }

        return s;


    }
}