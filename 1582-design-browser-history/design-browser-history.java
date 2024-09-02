class ListNode{
  String val;
  ListNode prev;
  ListNode next;

  public ListNode(String val){
    this.val = val;
  }
}

class BrowserHistory {
    ListNode head;

    public BrowserHistory(String homepage) {
      head = new ListNode(homepage);
    }
    
    public void visit(String url) {
      ListNode newNode = new ListNode(url);
      head.next = newNode;
      newNode.prev = head;

      head = head.next;
    }
    
    public String back(int steps) {
      while(head.prev != null && steps > 0){
        head = head.prev;
        steps--;
      }

      return head.val;
    }
    
    public String forward(int steps) {
      while(head.next != null && steps > 0){
        head = head.next;
        steps--;
      }

      return head.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */