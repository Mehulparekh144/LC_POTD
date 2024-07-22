class LockingTree {

    int[] locks;
    List<List<Integer>> adj;
    int[] parent;

    public LockingTree(int[] parent) {
        locks = new int[parent.length];
        this.parent = parent;
        Arrays.fill(locks , -1);
        adj = new ArrayList<>();

        for(int i = 0 ; i < parent.length ; i++){
          adj.add(new ArrayList<>());
        }

        for(int i = 1 ; i < parent.length ; i++){
          adj.get(parent[i]).add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if(locks[num] != -1) return false;
        locks[num] = user;
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(locks[num] != user) return false;
        locks[num] = -1;
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        if(locks[num] != -1) return false;

        int p = parent[num];
        while(p != -1){
          if(locks[p] != -1) return false;
          p = parent[p];
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(num);
        boolean hasLock = false;

        while(!q.isEmpty()){
          int node = q.poll();
          

          for(int child : adj.get(node)){
            if(locks[child] != -1){
              hasLock = true;
              locks[child] = -1;
            }
            q.offer(child);
          }
        }

        if(hasLock){
          locks[num] = user;
        }
        return hasLock;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */