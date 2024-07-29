class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");

        for(int i = 0 ; i < arr.length ; i++){
          arr[i] = reverse(arr[i]);
        }

        return String.join(" " , arr);
    }

    private String reverse(String s){
      StringBuilder sb = new StringBuilder();

      for(int i = s.length()-1 ; i>= 0 ; i--){
        sb.append(s.charAt(i));
      }

      return sb.toString();
    }
}