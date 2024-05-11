class Solution {
  class Pair{
    int wage;
    int quality;

    public Pair(int wage , int quality){
      this.wage = wage;
      this.quality = quality;
    }
  }
  public double mincostToHireWorkers(int[] quality, int[] wage, int k) {

    int n = quality.length;
    Pair[] workers = new Pair[n];

    for(int i = 0 ; i < n ; i++){
      workers[i] = new Pair(wage[i] , quality[i]);
    }

    Arrays.sort(workers , Comparator.comparingDouble(a -> (double) a.wage / (double) a.quality));

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
    double minCost = Double.MAX_VALUE;
    int qualitySum = 0;
    for(Pair worker : workers){
      pq.offer(worker.quality);
      qualitySum += worker.quality;

      if(pq.size() > k){
        qualitySum -= pq.poll();
      }

      if(pq.size() == k){
        minCost = Math.min(minCost , ((double) worker.wage / (double) worker.quality) * qualitySum);
      }
    }

    return minCost;
  }
}