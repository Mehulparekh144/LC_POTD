class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize != 0){
            return false;
        }

        Map<Integer,Integer> map = new HashMap<>();
        for(int num : hand){
            map.put(num , map.getOrDefault(num , 0 ) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int k : map.keySet()){
            pq.offer(k);
        }

        while(!pq.isEmpty()){
            int first = pq.peek();

            for(int i = first ; i < first + groupSize ; i++){
                if(!map.containsKey(i)){
                    return false;
                }

                map.put(i , map.get(i) - 1);
                if(map.get(i) == 0){
                    if(i != pq.peek()){
                        return false;
                    }

                    pq.remove(i);
                }
            }
        }

        return true;
    }
}