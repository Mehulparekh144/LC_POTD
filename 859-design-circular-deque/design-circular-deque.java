class Node{
  int val;
  Node prev;
  Node next;

  public Node(int val){
    this.val = val;
    this.prev = null;
    this.next = null;
  }
}
class MyCircularDeque {
    Node head;
    Node tail;
    int capacity;
    public MyCircularDeque(int k) {
        head = new Node(0);
        tail = new Node(1);
        capacity = k;
        head.next = tail;
        tail.prev = head;
    }
    
    public boolean insertFront(int value) {
        if(capacity == 0) return false;
        capacity--;
        Node newNode = new Node(value);
        Node next = head.next;
        head.next = newNode;
        next.prev = newNode;
        newNode.next = next;
        newNode.prev = head;

        return true;
    }
    
    public boolean insertLast(int value) {
        if(capacity == 0) return false;
        capacity--;

        Node newNode = new Node(value);
        Node prev = tail.prev;
        tail.prev = newNode;
        prev.next = newNode;
        newNode.next = tail;
        newNode.prev = prev;

        return true;
    }
    
public boolean deleteFront() {
    if (isEmpty()) return false;
    capacity++;
    
    Node toRemove = head.next;
    head.next = toRemove.next;
    head.next.prev = head;

    return true;
}

public boolean deleteLast() {
    if (isEmpty()) return false;
    capacity++;
    
    Node toRemove = tail.prev;
    tail.prev = toRemove.prev;
    tail.prev.next = tail;

    return true;
}

    
    public int getFront() {
      if(isEmpty()){
        return -1;
      }
        return head.next.val;
    }
    
    public int getRear() {
      if(isEmpty()){
        return -1;
      }
        return tail.prev.val;
    }
    
    public boolean isEmpty() {
        return head.next == tail;
    }
    
    public boolean isFull() {
        return capacity == 0;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */