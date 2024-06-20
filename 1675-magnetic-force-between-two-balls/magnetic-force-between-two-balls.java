class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1;
        int r = position[position.length - 1];

        while(l < r){
            int mid = (l+r+1)/2;

            if(canPlace(mid , position , m)){
                l = mid;
            } else{
                r = mid - 1;
            }
        }

        return l;
    }

    private boolean canPlace(int minDist , int position[] , int m){
        int count = 1; // Placed the ball
        int pos = position[0];

        for(int i = 1 ; i < position.length ; i++){
            if(position[i] - pos >= minDist){
                count++;
                pos = position[i];
                if(count == m){
                    return true;
                }
            }
        }

        return false;
    }
}