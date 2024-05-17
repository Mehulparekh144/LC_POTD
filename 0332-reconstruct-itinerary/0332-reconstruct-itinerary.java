class Solution {
	private void dfs(String from , Map<String,PriorityQueue<String>> adj , List<String> res ,
											List<List<String>> tickets){
		PriorityQueue<String> destinations = adj.get(from);
		while(!destinations.isEmpty()){
			dfs(destinations.poll() , adj , res , tickets);
		}
		res.addFirst(from);
	}
	public List<String> findItinerary(List<List<String>> tickets) {
		Set<String> set = new HashSet<>();
		for(List<String> ticket : tickets){
			set.add(ticket.get(0));
			set.add(ticket.get(1));
		}
		Map<String,PriorityQueue<String>> adj = new HashMap<>();

		for(String ticket : set){
			adj.put(ticket , new PriorityQueue<>());
		}
		for(List<String> ticket : tickets){
			String from = ticket.get(0);
			String to = ticket.get(1);
			adj.get(from).offer(to);
		}

		List<String> res = new ArrayList<>();
		dfs("JFK" , adj , res , tickets);
		return res;
	}
}