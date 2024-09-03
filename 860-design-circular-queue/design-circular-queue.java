class ListNode {
  int val;
  ListNode prev;
  ListNode next;

  public ListNode(int val) {
    this.val = val;
  }
}

class MyCircularQueue {

  ListNode head;
  ListNode tail;
  int k;
  int len;

  public MyCircularQueue(int k) {
    head = new ListNode(0);
    tail = new ListNode(0);

    head.next = tail;
    tail.prev = head;
    this.k = k;
    len = 0;
  }

  public boolean enQueue(int value) {
    if(len == k) return false;

    ListNode newNode = new ListNode(value);
    tail.prev.next = newNode;
    newNode.prev = tail.prev;
    newNode.next = tail;
    tail.prev = newNode;

    len++;
    return true;
  }

  public boolean deQueue() {
    if(len == 0) return false;

    ListNode temp = head.next;
    head.next = head.next.next;
    temp.next.prev = head;

    len--;
    return true;
  }

  public int Front() {
    if(head.next == tail) return -1;
    return head.next.val;
  }

  public int Rear() {
    if(tail.prev == head) return -1;
    return tail.prev.val;
  }

  public boolean isEmpty() {
    return len == 0;
  }

  public boolean isFull() {
    return len == k;
  }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */