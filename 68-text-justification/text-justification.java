class Solution {
   public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    int n = words.length;
    int i = 0;

    while (i < n) {
      int letters = words[i].length();
      int j = i + 1;
      int spaces = 0;

      while (j < n && spaces + letters + words[j].length() + 1 <= maxWidth) {
        letters += words[j].length();
        spaces += 1;
        j++;
      }

      int remainingSlots = maxWidth - letters;

      int eachWordSpace = spaces == 0 ? 0 : remainingSlots / spaces;
      int extraSpace = spaces == 0 ? 0 : remainingSlots % spaces;

      if (j == n) { // Last line, left justified
        eachWordSpace = 1;
        extraSpace = 0;
      }

      result.add(generateLine(i ,  j , eachWordSpace , extraSpace , words , maxWidth));
      i = j;
    }

    return result;
  }

  private String generateLine(int i , int j , int eachWordSpace , int extraSpace , String[] words ,
                              int maxWidth){
    StringBuilder s = new StringBuilder();

    for(int k = i ; k < j ; k++){
      s.append(words[k]);

      if(k == j - 1) continue;

      for(int space = 0 ; space < eachWordSpace ; space++ ){
        s.append(" ");
      }

      if(extraSpace > 0){
        s.append(" ");
        extraSpace--;
      }
    }

    while(s.length() < maxWidth){
      s.append(" ");
    }

    return s.toString();
  }
}