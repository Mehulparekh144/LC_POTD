class Solution {
  public List<String> findItinerary(List<List<String>> tickets) {
    Map<String, PriorityQueue<String>> map = new HashMap<>();

    for (List<String> edge : tickets) {
      String from = edge.get(0);
      String to = edge.get(1);
      if (map.containsKey(from)) {
        map.get(from).offer(to);
      } else {
        PriorityQueue<String> temp = new PriorityQueue<>();
        temp.offer(to);
        map.put(from, temp);
      }
    }

    List<String> res = new ArrayList<>();
    dfs("JFK" , res , map);
    return res;
  }

  private void dfs(String start , List<String> res , Map<String,PriorityQueue<String>> adj){
    PriorityQueue<String> destinations = adj.get(start);

    while(destinations != null &&!destinations.isEmpty()){
      dfs(destinations.poll() , res , adj);
    }
    res.addFirst(start);
  }
}