class MyStack {

    Deque<Integer> dq;

    public MyStack() {
        dq = new LinkedList<>();
    }
    
    public void push(int x) {
        dq.offerLast(x);
    }
    
    public int pop() {
        for(int i = 0 ; i < dq.size() - 1 ; i++){
          dq.offerLast(dq.pollFirst());
        }

        return dq.pollFirst();
    }
    
    public int top() {
        return dq.peekLast();
    }
    
    public boolean empty() {
        return dq.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */