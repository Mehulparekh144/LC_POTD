class MedianFinder {

  PriorityQueue<Integer> lmax;
  PriorityQueue<Integer> rmin;

  public MedianFinder() {
    lmax = new PriorityQueue<>((a, b) -> b - a);
    rmin = new PriorityQueue<>((a, b) -> a - b);
  }

  public void addNum(int num) {
    if (lmax.isEmpty() || num < lmax.peek()) {
      lmax.offer(num);
    } else {
      rmin.offer(num);
    }

    if (lmax.size() > rmin.size() + 1) {
      rmin.offer(lmax.poll());
    } else if (lmax.size() < rmin.size()) {
      lmax.offer(rmin.poll());
    }

  }

  public double findMedian() {
    if (lmax.size() == rmin.size()) {
      int n1 = lmax.peek();
      int n2 = rmin.peek();

      return (double)(n1 + n2) / 2;
    }

    return (double) lmax.peek();
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */