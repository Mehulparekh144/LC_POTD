class RandomizedSet {
    Map<Integer,Integer> map;
  List<Integer> list;
  public RandomizedSet() {
    map = new HashMap<>();
    list = new ArrayList<>();
  }

  public boolean insert(int val) {
    if(map.containsKey(val)) return false;

    list.addLast(val);
    map.put(val , list.size() - 1);
    return true;
  }

  public boolean remove(int val) {
    if(!map.containsKey(val)) return false;

    int idx = map.get(val);
    int lastElement = list.getLast();
    list.set(list.size() - 1 , val);

    list.set(idx , lastElement);
    map.put(lastElement , idx);

    list.removeLast();
    map.remove(val);

    return true;

  }

  public int getRandom() {
    Random rand = new Random();
    int ridx = rand.nextInt(list.size());
    return list.get(ridx);
  }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */