class ListNode {
  int val;
  ListNode prev;
  ListNode next;

  public ListNode(int val) {
    this.val = val;
  }
}

class MyLinkedList {

  ListNode head;
  ListNode tail;

  public MyLinkedList() {
    head = new ListNode(0);
    tail = new ListNode(0);
    head.next = tail;
    tail.prev = head;
  }

  public int get(int index) {
    ListNode curr = head.next;

    while (curr != null && index > 0) {
      curr = curr.next;
      index--;
    }

    if (curr != null && curr != this.tail && index == 0) {
      return curr.val;
    }

    return -1;
  }

  public void addAtHead(int val) {
    ListNode newNode = new ListNode(val);
    head.next.prev = newNode;
    newNode.next = head.next;
    head.next = newNode;
    newNode.prev = head;
  }

  public void addAtTail(int val) {
    ListNode newNode = new ListNode(val);
    tail.prev.next = newNode;
    newNode.prev = tail.prev;
    tail.prev = newNode;
    newNode.next = tail;
  }

  public void addAtIndex(int index, int val) {
    ListNode curr = head.next;

    while (curr != null && index > 0) {
      curr = curr.next;
      index--;
    }

    if (curr != null && index == 0) {
      ListNode newNode = new ListNode(val);
      curr.prev.next = newNode;
      newNode.prev = curr.prev;
      curr.prev = newNode;
      newNode.next = curr;
    }
  }

  public void deleteAtIndex(int index) {
    ListNode curr = head.next;

    while(curr != null  && index > 0){
      curr = curr.next;
      index--;
    }

    if(curr != null && curr != tail && index == 0){
      curr.prev.next = curr.next;
      curr.next.prev = curr.prev;
    }
  }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */