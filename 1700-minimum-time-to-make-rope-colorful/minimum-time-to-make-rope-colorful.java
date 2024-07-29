class Solution {
  public int minCost(String colors, int[] neededTime) {
    int i = 0;
    int j = i + 1;

    int n = colors.length();
    char[] c = colors.toCharArray();

    int time = 0;

    while (j < n) {
      if (c[i] == c[j]) {
        if (neededTime[i] < neededTime[j]) {
          time += neededTime[i];
          i = j;
        } else {
          time += neededTime[j];
        }
        j++;
      } else {
        i = j++;
      }
    }

    return time;
  }
}