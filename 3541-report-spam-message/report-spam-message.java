class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        int count = 0;
        Set<String> banned = new HashSet<>();

        for(String b : bannedWords) banned.add(b);

        for(String m : message){
          if(banned.contains(m)){
            count++;
            if(count == 2){
              return true;
              
            }
          }
        }

        return count == 2;
    }
}