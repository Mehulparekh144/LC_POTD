class Solution {
   public int compareVersion(String version1, String version2) {
    int i = 0;
    int j = 0;

    while(i < version1.length() || j < version2.length()){
      StringBuilder curr1 = new StringBuilder();
      StringBuilder curr2 = new StringBuilder();

      while(i < version1.length() && version1.charAt(i) != '.'){
        curr1.append(version1.charAt(i));
        i++;
      }

      while(j < version2.length() && version2.charAt(j) != '.'){
        curr2.append(version2.charAt(j));
        j++;
      }

      int num1 = curr1.length() == 0 ? 0 : Integer.parseInt(curr1.toString());
      int num2 = curr2.length() == 0 ? 0 : Integer.parseInt(curr2.toString());

      if(num1 != num2) return Integer.compare(num1, num2);
      i++;
      j++;
    }

    return 0;}
}