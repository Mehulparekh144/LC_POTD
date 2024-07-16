/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
	class Pair{
		int node;
		String direction;

		public Pair(int node , String direction){
			this.node = node;
			this.direction = direction;
		}

		@Override
		public String toString() {
			return "Pair{" +
					"node=" + node +
					", direction='" + direction + '\'' +
					'}';
		}
	}

	public String getDirections(TreeNode root, int startValue, int destValue) {
		// Number of nodes
		int n = countNodes(root);

		// Creating Graph
		List<List<Pair>> adj = new ArrayList<>();
		for(int i = 0 ; i <= n ; i++){
			adj.add(new ArrayList<>());
		}

		TreeNode curr = root;
		dfs(curr , adj);

		Queue<Pair> q = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		q.add(new Pair(startValue , ""));
		visited[startValue] = true;

		while(!q.isEmpty()){
			Pair currPair = q.poll();
			if(currPair.node == destValue){
				return currPair.direction;
			}
			for(Pair p : adj.get(currPair.node)){
				if(!visited[p.node]){
					visited[p.node] = true;
					q.add(new Pair(p.node , currPair.direction + p.direction));
				}
			}
		}

		return "";


	}

	private void dfs(TreeNode curr , List<List<Pair>> adj){
		if(curr == null){
			return;
		}

		if(curr.left != null){
			adj.get(curr.val).add(new Pair(curr.left.val , "L"));
			adj.get(curr.left.val).add(new Pair(curr.val , "U"));
			dfs(curr.left , adj);
		}

		if(curr.right != null){
			adj.get(curr.val).add(new Pair(curr.right.val , "R"));
			adj.get(curr.right.val).add(new Pair(curr.val , "U"));
			dfs(curr.right , adj);
		}
	}

	private int countNodes(TreeNode root ){
		if(root == null){
			return 0;
		}

		return 1 + countNodes(root.left) + countNodes(root.right);
	}
}