class Solution {

    class DisjointSet{
      List<Integer> parent;
      List<Integer> size;

      public DisjointSet(int n){
        parent = new ArrayList<>();
        size = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
          parent.add(i);
          size.add(1);
        }
      }

      public int find(int node){
        if(node == parent.get(node)) return node;
        parent.set(node , find(parent.get(node)));
        return parent.get(node);
      }

      public void union(int u , int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return;
        int sizeu = size.get(pu);
        int sizev = size.get(pv);

        if(sizeu > sizev){
          parent.set(pv , pu);
          size.set(pu , sizev + sizeu);
        } else{
          parent.set(pu , pv);
          size.set(pv , sizeu + sizev);
        }
      }
    }


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
      DisjointSet ds = new DisjointSet(accounts.size());
      Map<String,Integer> map = new HashMap<>();

      for(int i = 0 ; i < accounts.size() ; i++){
        for(int j = 1 ; j < accounts.get(i).size() ; j++){
          if(!map.containsKey(accounts.get(i).get(j))){
            map.put(accounts.get(i).get(j) , i );
          } else{
            ds.union(i , map.get(accounts.get(i).get(j)));
          }
        }
      }

      List<String>[] merged = new ArrayList[accounts.size()];
      for(int i = 0 ; i < accounts.size() ; i++){
        merged[i] = new ArrayList<>();
      } 

      for(Map.Entry<String,Integer> entry : map.entrySet()){
        String email = entry.getKey();
        int idx = ds.find(entry.getValue());
        merged[idx].add(email);  
      }

      List<List<String>> res = new ArrayList<>();

      for(int i = 0 ; i < merged.length ; i++){
        if(merged[i].size() == 0) continue;
        String name = accounts.get(i).get(0);
        Collections.sort(merged[i]);
        List<String> temp = new ArrayList<>();
        temp.add(name);
        temp.addAll(merged[i]);
        res.add(temp);
      }

      return res;

      
    }
}